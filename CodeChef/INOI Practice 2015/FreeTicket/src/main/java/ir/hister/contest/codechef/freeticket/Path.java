package ir.hister.contest.codechef.freeticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/29/2016.
 *
 * @author Khaled Bakhtiari
 */
public class Path {
    private List<Route> routes;

    public Path() {
        this(null);
    }

    public Path(Path path) {
        routes = new ArrayList<>();
        if (path != null) {
            routes.addAll(path.routes);
        }
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    @Override
    public String toString() {
        return getFrom() + " to " + getTo() + " by " + getRouteCount();
    }

    public int getRouteCount() {
        return routes.size();
    }

    public int getPrice() {
        int price = 0;
        for (Route route : routes) {
            price += route.getPrice();
        }
        return price;
    }

    public int getFrom() {
        if (routes.size() == 0)
            return 0;

        return routes.get(0).getFrom();
    }

    public int getTo() {
        int size = routes.size();
        if (size == 0)
            return 0;

        return routes.get(size - 1).getTo();
    }
}
