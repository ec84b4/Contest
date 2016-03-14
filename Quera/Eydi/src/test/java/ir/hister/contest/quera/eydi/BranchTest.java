package ir.hister.contest.quera.eydi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khbak on 3/14/2016.
 */
public class BranchTest {
    private Branch branch;

    @Before
    public void setUp() throws Exception {
        branch = new Branch();
    }

    @Test
    public void testAddEydi() throws Exception {
        addEydi();
    }

    @Test
    public void testBranchSize() throws Exception {
        addEydi();
        assertEquals(1, branch.getSize());
    }

    @Test
    public void testContains() throws Exception {
        assertFalse(branch.contains(EydiTest.newEydi()));
        branch.addEydi(EydiTest.newEydi());
        assertTrue(branch.contains(EydiTest.newEydi()));
    }

    private void addEydi() {
        Eydi eydi = EydiTest.newEydi();
        branch.addEydi(eydi);
    }

}