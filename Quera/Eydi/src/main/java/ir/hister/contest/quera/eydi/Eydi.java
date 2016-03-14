package ir.hister.contest.quera.eydi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khbak on 3/12/2016.
 */
public class Eydi {
    public static final char E = 'E', I = 'I', D = 'D', Y = 'Y';

    private char[][] table;
    private List<Holder> foundEydis;

    public Eydi(char[][] table) {
        this.table = table;
        foundEydis = new ArrayList<>();
    }

    public int countEydis() {
        findNextEydi(new Index(-1, -1));

        int size = foundEydis.size();

        if (size == 0)
            throw new PoorMobin();

        return size;
    }

    private void findNextEydi(Index index) {
        Holder eydi = findEydi(index);

        if (eydi != null) {
            Holder lastEydi = getLastEydi();
            if (eydi.equals(lastEydi)) {
                throw new PoorUncle();
            }
            foundEydis.add(eydi);
            findNextEydi(eydi.getY());
        }
    }

    private Holder findEydi(Index index) {
        Index e = findNextIndex(E, index);
        if (e == null)
            return null;

        Index i = findNextIndex(I, e);
        if (i == null)
            return null;

        Index d = findNextIndex(D, i);
        if (d == null)
            return null;

        Index y = findNextIndex(Y, d);
        if (y == null)
            return null;

        return new Holder(e, i, d, y);
    }

    public Index findFirsIndex(char toFind) {
        return findNextIndex(toFind, new Index(-1, -1));
    }

    public Index findNextIndex(char target, Index index) {
        int rowCount = table.length;
        int rowStart = index.getRow();
        int columnStart = index.getColumn();

        for (int row = rowStart; row < rowCount; row++) {
            if (!isInRange(row, rowCount))
                continue;

            int columnCount = getRowLength(row);
            for (int column = columnStart; column < columnCount; column++) {
                if (isInThisPosition(target, row, column - 1))
                    return new Index(row, column - 1);

                if (isInThisPosition(target, row - 1, column))
                    return new Index(row - 1, column);

                if (isInThisPosition(target, row, column + 1))
                    return new Index(row, column + 1);

                if (isInThisPosition(target, row + 1, column))
                    return new Index(row + 1, column);
            }
        }

        return null;
    }

    private boolean isInThisPosition(char c, int row, int column) {
        if (!isInRange(row, table.length))
            return false;

        if (!isInRange(column, getRowLength(row)))
            return false;

        return table[row][column] == c;
    }

    private boolean isInRange(int i, int length) {
        return i >= 0 && i < length;
    }

    public Index getNextIndex(Index index) {
        int row = index.getRow();
        int column = index.getColumn();

        if (row < 0)
            return new Index(0, 0);

        int rowLength = getRowLength(row);
        if (column + 1 < rowLength)
            return new Index(row, column + 1);

        return new Index(row + 1, 0);
    }

    private int getRowLength(int rowIndex) {
        return table[rowIndex].length;
    }

    public Holder getLastEydi() {
        int size = foundEydis.size();
        if (size == 0)
            return null;

        return foundEydis.get(size - 1);
    }

    public static class Index {
        private final int row;
        private final int column;

        public Index(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }


        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Index))
                return false;

            Index o = (Index) obj;

            return column == o.column && row == o.row;
        }

        @Override
        public String toString() {
            return " [" + row + " " + column + "]";
        }
    }

    public static class Holder {
        private Index e, i, d, y;

        public Holder(Index e, Index i, Index d, Index y) {
            this.e = e;
            this.i = i;
            this.d = d;
            this.y = y;
        }

        public Index getE() {
            return e;
        }

        public Index getI() {
            return i;
        }

        public Index getD() {
            return d;
        }

        public Index getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Holder))
                return false;

            Holder o = (Holder) obj;

            return e.equals(o.e) && i.equals(o.i) && d.equals(o.d) && y.equals(o.y);
        }

        @Override
        public String toString() {
            return e.toString() + i.toString() + d.toString() + y.toString();
        }
    }

    public static class OurException extends RuntimeException {
    }

    public static class PoorMobin extends OurException {

    }

    public static class PoorUncle extends OurException {

    }
}