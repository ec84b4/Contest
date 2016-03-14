package ir.hister.contest.quera.eydi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khbak on 3/14/2016.
 */
public class EydiFinder {
    public static final char E = 'E', I = 'I', D = 'D', Y = 'Y';

    private final char[][] table;
    private List<Branch> branches;

    public EydiFinder(char[][] table) {
        this.table = table;
        branches = new ArrayList<>();
        validate();
    }

    private void validate() {
        if (table.length == 0)
            throw new EmptyTableException();

        for (char[] row : table) {
            if (row.length != getColumnCount()) {
                throw new UnEqualRowSizesException();
            }
        }
    }

    public int countEydis() {
        if (table.length == 0)
            throw new NoEydiFoundException();

        for (int row = 0; row < getRowCount(); row++) {
            for (int column = 0; column < getColumnCount(); column++) {
                if (table[row][column] == E) {
                    Index e = new Index(E, row, column);
                    Eydi eydi = new Eydi();
                    eydi.setE(e);
                    loopIndexes(null, eydi, e);
                }
            }
        }

        int count = 0;
        for (Branch branch : branches) {
            if (branch.getSize() > count)
                count = branch.getSize();
        }

        if (count == 0)
            throw new NoEydiFoundException();

        return count;
    }

    private void loopIndexes(Branch parent, Eydi lastEydi, Index start) {
        List<Index> indexes = findNextIndexes(start);

        if (indexes.size() == 0)
            return;

        for (Index index : indexes) {
            Eydi eydi = new Eydi(lastEydi);
            eydi.setIndex(index);

            Branch branch = parent;
            if (eydi.isComplete()) {
                branch = newBranch(parent);
                branch.addEydi(eydi);

                eydi = new Eydi();
            }

            loopIndexes(branch, eydi, index);
        }
    }

    private Branch newBranch(Branch parent) {
        Branch branch = new Branch(parent);
        branches.add(branch);
        return branch;
    }

    public Index getFirstIndex() {
        return getNextIndex(null);
    }

    public Index getNextIndex(Index index) {
        if (index == null)
            return new Index(E, 0, 0);

        int row = index.getRow();
        int column = index.getColumn();

        if (column + 1 < getColumnCount())
            return new Index(table[row][column + 1], row, column + 1);

        return new Index(table[row + 1][column], row + 1, 0);
    }

    public List<Index> findNextIndexes(Index index) {
        List<Index> indexes = new ArrayList<>();
        char target = index.getNextChar();
        int row = index.getRow();
        int column = index.getColumn();

        if (isInThisPosition(target, row, column - 1))//left char
            indexes.add(new Index(target, row, column - 1));

        if (isInThisPosition(target, row - 1, column))//top char
            indexes.add(new Index(target, row - 1, column));

        if (isInThisPosition(target, row, column + 1))//right char
            indexes.add(new Index(target, row, column + 1));

        if (isInThisPosition(target, row + 1, column))//below char
            indexes.add(new Index(target, row + 1, column));

        return indexes;
    }

    private boolean isInThisPosition(char c, int row, int column) {
        if (!isInRange(row, getRowCount()))
            return false;

        if (!isInRange(column, getColumnCount()))
            return false;

        return table[row][column] == c;
    }

    private boolean isInRange(int i, int length) {
        return i >= 0 && i < length;
    }

    private int getRowCount() {
        return table.length;
    }

    private int getColumnCount() {
        return table[0].length;
    }

    public static class EmptyTableException extends RuntimeException {
        public EmptyTableException() {
            super("table with size zero was given");
        }
    }

    public static class UnEqualRowSizesException extends RuntimeException {
        public UnEqualRowSizesException() {
            super("not all rows have the same size");
        }
    }
}