package ir.hister.contest.codechef.freeticket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/29/2016.
 *
 * @author Khaled Bakhtiari
 */
public class PathTest {
    private Path path;

    @Before
    public void setUp() throws Exception {
        path = new Path();
        path.addRoute(new Route(1, 2, 10));
    }

    @Test
    public void addRoute() throws Exception {
        path.addRoute(new Route(1, 2, 10));
    }

    @Test
    public void testRoutesCount() throws Exception {
        Assert.assertEquals(1, path.getRouteCount());
    }

    @Test
    public void testGetPrice() throws Exception {
        path.addRoute(new Route(2, 3, 5));
        Assert.assertEquals(15, path.getPrice());
    }
}
