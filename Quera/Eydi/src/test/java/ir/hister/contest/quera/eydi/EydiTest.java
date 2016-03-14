package ir.hister.contest.quera.eydi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static ir.hister.contest.quera.eydi.Eydi.D;
import static ir.hister.contest.quera.eydi.Eydi.E;
import static ir.hister.contest.quera.eydi.Eydi.I;
import static ir.hister.contest.quera.eydi.Eydi.Y;

/**
 * Created by khbak on 3/12/2016.
 */
public class EydiTest {
    private Eydi eydi;

    @Before
    public void setUp() throws Exception {
        char[][] table = new char[][]{
                new char[]{'E', 'Y', 'D', 'I', 'E'},
                new char[]{'E', 'Y', 'D', 'I', 'Y'},
                new char[]{'E', 'Y', 'D', 'I', 'D'},
                new char[]{'E', 'E', 'D', 'I', 'I'},
                new char[]{'I', 'I', 'D', 'Y', 'E'}
        };
        eydi = new Eydi(table);
    }

    @Test
    public void testFindFirstIndex() {
        char[][] table = new char[][]{
                new char[]{'E', 'E'},
                new char[]{'D', 'I'},
                new char[]{'Y', 'E'},
        };
        eydi = new Eydi(table);

        Assert.assertEquals(eydi.findFirsIndex(E), new Eydi.Index(0, 0));
        Assert.assertEquals(eydi.findFirsIndex(Y), new Eydi.Index(2, 0));
        Assert.assertEquals(eydi.findFirsIndex(D), new Eydi.Index(1, 0));
        Assert.assertEquals(eydi.findFirsIndex(I), new Eydi.Index(1, 1));
    }

    @Test
    public void testCountEydis() {
        char[][] table = new char[][]{
                new char[]{'E', 'Y', 'D', 'I', 'E'},
                new char[]{'E', 'Y', 'D', 'I', 'Y'},
                new char[]{'E', 'Y', 'D', 'I', 'D'},
                new char[]{'E', 'E', 'D', 'I', 'I'},
                new char[]{'I', 'I', 'D', 'Y', 'E'}
        };
        eydi = new Eydi(table);

//        Assert.assertEquals(4, eydi.countEydis());
    }

    @Test(expected = Eydi.PoorMobin.class)
    public void testMustThrowPoorMobin() {
        char[][] table = new char[][]{
                new char[]{'E', 'Y'},
        };
        eydi = new Eydi(table);
        eydi.countEydis();
    }

    @Test(expected = Eydi.PoorUncle.class)
    public void testMustThrowPoorUncle() {
        char[][] table = new char[][]{
                new char[]{'D', 'I'},
                new char[]{'Y', 'E'},
        };
        eydi = new Eydi(table);
        eydi.countEydis();
    }
}