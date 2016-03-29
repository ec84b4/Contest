package ir.hister.contest.codechef.freeticket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/29/2016.
 *
 * @author Khaled Bakhtiari
 */
public class FreeTicketTest {
    FreeTicket freeTicket;

    @Before
    public void setUp() throws Exception {
        int cityCount = 4;
        int routeCount = 5;
        freeTicket = new FreeTicket(cityCount);
        freeTicket.addRoute(new Route(1, 2, 10));
        freeTicket.addRoute(new Route(1, 3, 24));
        freeTicket.addRoute(new Route(2, 3, 2));
        freeTicket.addRoute(new Route(2, 4, 15));
        freeTicket.addRoute(new Route(3, 4, 7));
    }

    @Test
    public void testAddRoute() throws Exception {
        FreeTicket freeTicket = new FreeTicket(1);
        int cityStart = 1;
        int cityEnd = 2;
        int price = 3;
        Route route = new Route(cityStart, cityEnd, price);
        freeTicket.addRoute(route);

        Assert.assertEquals(1, freeTicket.getRouteCount());

        freeTicket.addRoute(route);

        Assert.assertEquals(2, freeTicket.getRouteCount());
    }

    @Test
    public void testLongestPath() throws Exception {
        Path path = freeTicket.getLongestPath();
        Assert.assertEquals(19, path.getPrice());
    }

    @Test
    public void testLongestPath2() throws Exception {
        freeTicket = new FreeTicket(6);
        freeTicket.addRoute(new Route(1, 2, 10));
        freeTicket.addRoute(new Route(1, 3, 24));
        freeTicket.addRoute(new Route(2, 3, 2));
        freeTicket.addRoute(new Route(2, 4, 15));
        freeTicket.addRoute(new Route(3, 5, 10));
        freeTicket.addRoute(new Route(5, 6, 3));
        freeTicket.addRoute(new Route(4, 6, 1));
        Assert.assertEquals(19, freeTicket.getLongestPath().getPrice());
    }
}