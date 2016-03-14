package ir.hister.contest.quera.eydi;

/**
 * Created by khbak on 3/14/2016.
 */
public class Eydi {
    private Index e, y, i, d;

    public Eydi() {
        this(null, null, null, null);
    }

    public Eydi(Eydi eydi) {
        this(eydi.getE(), eydi.getY(), eydi.getD(), eydi.getI());
    }

    public Eydi(Index e, Index y, Index d, Index i) {
        this.e = e;
        this.y = y;
        this.d = d;
        this.i = i;
    }

    public Index getE() {
        return e;
    }

    public void setE(Index e) {
        this.e = e;
    }

    public Index getY() {
        return y;
    }

    public void setY(Index y) {
        this.y = y;
    }

    public Index getD() {
        return d;
    }

    public void setD(Index d) {
        this.d = d;
    }

    public Index getI() {
        return i;
    }

    public void setI(Index i) {
        this.i = i;
    }

    public void setIndex(Index i) {
        switch (i.getChar()) {
            case EydiFinder.E:
                setE(i);
                break;
            case EydiFinder.Y:
                setY(i);
                break;
            case EydiFinder.D:
                setD(i);
                break;
            case EydiFinder.I:
                setI(i);
                break;

        }
    }

    public boolean isComplete() {
        return !(e == null || y == null || d == null || i == null);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Eydi))
            return false;

        Eydi o = (Eydi) obj;

        return equals(e, o.e) && equals(y, o.y) && equals(d, o.d) && equals(i, o.i);
    }

    private boolean equals(Index i1, Index i2) {
        if (i1 == null && i2 == null)
            return true;

        if (i1 == null || i2 == null)
            return false;

        return i1.equals(i2);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", toString(e), toString(y), toString(d), toString(i));
    }

    private String toString(Index index) {
        if (index == null)
            return "[-,-]";

        return index.toString();
    }

    public Index getLastIndex() {
        if (i != null)
            return i;

        if (d != null)
            return d;

        if (y != null)
            return y;

        if (e != null)
            return e;

        return null;
    }

}