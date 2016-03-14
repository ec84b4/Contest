package ir.hister.contest.quera.eydi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by khbak on 3/14/2016.
 */
public class IndexTest {
    private static final int ROW = 2, COLUMN = 3;
    private Index index;

    public static Index newIndex() {
        return new Index(EydiFinder.E, ROW, COLUMN);
    }

    @Before
    public void setUp() throws Exception {
        index = newIndex();
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertFalse(index.equals(1));
        Assert.assertTrue(index.equals(new Index(EydiFinder.E, ROW, COLUMN)));
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals(String.format("[%d,%d]", ROW, COLUMN), index.toString());
    }

    @Test
    public void testGetRow() throws Exception {
        Assert.assertEquals(ROW, index.getRow());
    }

    @Test
    public void testGetColumn() throws Exception {
        Assert.assertEquals(COLUMN, index.getColumn());
    }
}