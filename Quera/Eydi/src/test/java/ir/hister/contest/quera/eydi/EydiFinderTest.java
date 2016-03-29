package ir.hister.contest.quera.eydi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by khbak on 3/14/2016.
 */
public class EydiFinderTest {
    EydiFinder eydiFinder;

    @Before
    public void setUp() {
        char[][] table = new char[][]{
                new char[]{'E', 'Y', 'D', 'I', 'E'},
                new char[]{'E', 'Y', 'D', 'I', 'Y'},
                new char[]{'E', 'Y', 'D', 'I', 'D'},
                new char[]{'E', 'E', 'D', 'I', 'I'},
                new char[]{'I', 'I', 'D', 'Y', 'E'}
        };
        eydiFinder = new EydiFinder(table);
    }

    @Test(expected = EydiFinder.EmptyTableException.class)
    public void emptyTable() throws Exception {
        eydiFinder = new EydiFinder(new char[0][0]);
    }

    @Test(expected = EydiFinder.UnEqualRowSizesException.class)
    public void tableWithUnEqualRowSize() throws Exception {
        char[][] table = new char[][]{
                new char[]{'E', 'Y', 'D', 'I', 'E'},
                new char[]{'E', 'Y', 'D', 'I'},
        };
        eydiFinder = new EydiFinder(table);
    }

    @Test
    public void testGetFirstIndex() throws Exception {
        assertEquals(new Index(EydiFinder.E, 0, 0), eydiFinder.getFirstIndex());
    }

    @Test
    public void testFindNextIndex() throws Exception {
        Index previousIndex = new Index(EydiFinder.E, 0, 0);
        assertEquals(new Index(EydiFinder.Y, 0, 1), eydiFinder.getNextIndex(previousIndex));
        previousIndex = new Index(EydiFinder.D, 0, 1);
        assertEquals(new Index(EydiFinder.I, 0, 2), eydiFinder.getNextIndex(previousIndex));
        previousIndex = new Index(EydiFinder.E, 0, 4);
        assertEquals(new Index(EydiFinder.E, 1, 0), eydiFinder.getNextIndex(previousIndex));
    }

    @Test(expected = NoEydiFoundException.class)
    public void testNoEydi() throws Exception {
        char[][] table = new char[][]{
                new char[]{'E', 'Y'},
        };
        eydiFinder = new EydiFinder(table);
        eydiFinder.countEydis();
    }

    @Test(expected = EndlessEydisFoundException.class)
    public void testEndlessEydis() {
        char[][] table = new char[][]{
                new char[]{'D', 'I'},
                new char[]{'Y', 'E'},
        };
        eydiFinder = new EydiFinder(table);
        eydiFinder.countEydis();
    }

    @Test
    public void testCountEydis() throws Exception {
        Assert.assertEquals(4, eydiFinder.countEydis());

//        Random random = new Random();
//        int rowCount = random.nextInt(10);
//        int columnCount = random.nextInt(10);
//        char[][] table = new char[rowCount][columnCount];
//        for (int row = 0; row < rowCount; row++) {
//            for (int column = 0; column < columnCount; column++) {
//                int i = random.nextInt(4);
//                switch (i) {
//                    case 0:
//                        table[row][column] = EydiFinder.E;
//                        break;
//                    case 1:
//                        table[row][column] = EydiFinder.Y;
//                        break;
//                    case 2:
//                        table[row][column] = EydiFinder.D;
//                        break;
//                    case 3:
//                        table[row][column] = EydiFinder.I;
//                        break;
//                }
//            }
//        }
//        eydiFinder = new EydiFinder(table);
//        System.out.println(eydiFinder.countEydis());
//        for (char[] chars : table) {
//            System.out.println(Arrays.toString(chars));
//        }
    }
}
