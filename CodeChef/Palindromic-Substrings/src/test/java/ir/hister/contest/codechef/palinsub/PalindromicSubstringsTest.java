package ir.hister.contest.codechef.palinsub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/15/2016.
 *
 * @author Khaled Bakhtiari
 */
public class PalindromicSubStringsTest {
    Main palindromic;

    @Before
    public void setUp() throws Exception {
        palindromic = new Main("abc", "abc");
    }

    @Test
    public void testMakePalindromicSubStrings() throws Exception {
        palindromic = new Main("abc", "abc");
    }

    @Test
    public void testHaveCommonChars() throws Exception {
        assertTrue(palindromic.haveCommonChars());
    }

    @Test
    public void testGetFirstCommonChar() throws Exception {
        char c = palindromic.getFirstCommonChar();
        Assert.assertEquals('a', c);
    }

    @Test
    public void testIsPalindromic() throws Exception {
        assertTrue(palindromic.isPalindromic());
        assertFalse(new Main("a", "b").isPalindromic());
        assertTrue(new Main("abba", "baab").isPalindromic());
    }

    @Test
    public void testMain() throws Exception {
        String test = "3\n" +
                "abc\n" +
                "abc\n" +
                "a\n" +
                "b\n" +
                "abba\n" +
                "baab";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Main.main(null);

        Assert.assertEquals("Yes\r\nNo\r\nYes\r\n", baos.toString());
    }
}