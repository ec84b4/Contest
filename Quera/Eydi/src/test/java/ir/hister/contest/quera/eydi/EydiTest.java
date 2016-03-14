package ir.hister.contest.quera.eydi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khbak on 3/14/2016.
 */
public class EydiTest {
    private static final Index E = new Index(EydiFinder.E, 0, 0), Y = new Index(EydiFinder.Y, 0, 1),
            D = new Index(EydiFinder.D, 0, 2), I = new Index(EydiFinder.I, 0, 3);

    Eydi eydi;

    public static Eydi newEydi() {
        return new Eydi(E, Y, D, I);
    }

    @Before
    public void setUp() throws Exception {
        eydi = newEydi();
    }

    @Test
    public void testEquals() throws Exception {
        assertFalse(eydi.equals(1));
        assertFalse(eydi.equals(new Eydi(Y, E, D, I)));
        assertTrue(eydi.equals(new Eydi(E, Y, D, I)));

        eydi = new Eydi(null, null, null, null);
        assertTrue(eydi.equals(new Eydi(null, null, null, null)));

        eydi = new Eydi(E, null, null, null);
        assertFalse(eydi.equals(new Eydi(null, null, null, null)));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("[0,0] [0,1] [0,2] [0,3]", eydi.toString());
        eydi = new Eydi(null, null, null, null);
        assertEquals("[-,-] [-,-] [-,-] [-,-]", eydi.toString());
    }

    @Test
    public void testGetE() throws Exception {
        assertTrue(E.equals(eydi.getE()));
    }

    @Test
    public void testGetY() throws Exception {
        assertTrue(Y.equals(eydi.getY()));
    }

    @Test
    public void testGetD() throws Exception {
        assertTrue(D.equals(eydi.getD()));
    }

    @Test
    public void testGetI() throws Exception {
        assertTrue(I.equals(eydi.getI()));
    }

    @Test
    public void testSetE() throws Exception {
        eydi.setE(Y);
        assertTrue(Y.equals(eydi.getE()));
    }

    @Test
    public void testSetY() throws Exception {
        eydi.setY(D);
        assertTrue(D.equals(eydi.getY()));
    }

    @Test
    public void testSetD() throws Exception {
        eydi.setD(I);
        assertTrue(I.equals(eydi.getD()));
    }

    @Test
    public void testSetI() throws Exception {
        eydi.setI(E);
        assertTrue(E.equals(eydi.getI()));
    }

    @Test
    public void testIsComplete() throws Exception {
        assertTrue(eydi.isComplete());
    }

    @Test
    public void testGetLastIndex() throws Exception {
        eydi = new Eydi();
        eydi.setE(Y);
        Assert.assertEquals(Y, eydi.getLastIndex());
        eydi.setE(E);
        Assert.assertEquals(E, eydi.getLastIndex());
    }

    @Test
    public void testSetIndex() throws Exception {
        eydi.setIndex(E);
        assertEquals(E, eydi.getE());

        eydi.setIndex(Y);
        assertEquals(Y, eydi.getY());

        eydi.setIndex(D);
        assertEquals(D, eydi.getD());

        eydi.setIndex(I);
        assertEquals(I, eydi.getI());
    }
}