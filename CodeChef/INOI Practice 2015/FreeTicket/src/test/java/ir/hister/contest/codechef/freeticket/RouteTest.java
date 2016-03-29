package ir.hister.contest.codechef.freeticket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/29/2016.
 *
 * @author Khaled Bakhtiari
 */
public class RouteTest {
    private Route route;

    @Before
    public void setUp() throws Exception {
        route = new Route(1, 2, 10);
    }

    @Test
    public void testGetPrice() throws Exception {
        Assert.assertEquals(10, route.getPrice());
    }

    @Test
    public void testGetStart() throws Exception {
        Assert.assertEquals(1, route.getFrom());
    }

    @Test
    public void testGetEnd() throws Exception {
        Assert.assertEquals(2, route.getTo());
    }

    @Test
    public void testEquals() throws Exception {
        Route secondRoute;

        secondRoute = new Route(1, 2, 10);
        Assert.assertEquals(route, secondRoute);

        secondRoute = new Route(2, 1, 10);
        Assert.assertEquals(route, secondRoute);

        secondRoute = new Route(1, 3, 10);
        Assert.assertNotEquals(route, secondRoute);

        secondRoute = new Route(1, 2, 15);
        Assert.assertNotEquals(route, secondRoute);
    }

    @Test
    public void testStartsFrom() throws Exception {
        Assert.assertTrue(route.startsFrom(1));
    }

    @Test
    public void testEndTo() throws Exception {
        Assert.assertTrue(route.endTo(2));
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals("1-2=10", route.toString());
    }
}