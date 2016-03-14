package ir.hister.contest.quera.eydi;

/**
 * Created by khbak on 3/14/2016.
 */
public class Index {
    private final char c;
    private final int row;
    private final int column;

    public Index(char c, int row, int column) {
        this.c = c;
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

    public char getChar() {
        return c;
    }

    public char getNextChar() {
        switch (getChar()) {
            case EydiFinder.E:
                return EydiFinder.Y;
            case EydiFinder.Y:
                return EydiFinder.D;
            case EydiFinder.D:
                return EydiFinder.I;
            case EydiFinder.I:
                return EydiFinder.E;

            default:
                throw new RuntimeException("no such char " + getChar());
        }
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", row, column);
    }
}