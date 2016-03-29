package ir.hister.contest.codechef.freeticket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/29/2016.
 *
 * @author Khaled Bakhtiari
 */
public class FreeTicket {
    private final int cityCount;
    private List<Route> routes;

    public FreeTicket(int cityCount) {
        this.cityCount = cityCount;
        this.routes = new ArrayList<>();
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public int getRouteCount() {
        return routes.size();
    }

    public Path getLongestPath() {
        List<Path> paths = new ArrayList<>();
        for (int from = 1; from < cityCount + 1; from++) {
            for (int to = 1; to < cityCount + 1; to++) {
                Path path = getLongestCheapestPath(getPaths(from, to));
                if (path != null)
                    paths.add(path);
            }
        }
        return getLongestCheapestPath(paths);
    }

    private List<Path> getPaths(int from, int to) {
        return new PathFinder(from, to).getPaths();
    }

    private Path getLongestCheapestPath(List<Path> paths) {
        int longestRouteCount = 0;
        for (Path path : paths) {
            if (path.getRouteCount() > longestRouteCount)
                longestRouteCount = path.getRouteCount();
        }

        Path cheapestPath = null;
        for (Path path : paths) {
            if (path.getRouteCount() == longestRouteCount) {
                if (cheapestPath == null || path.getPrice() < cheapestPath.getPrice())
                    cheapestPath = path;
            }
        }
        return cheapestPath;
    }

    private class PathFinder {
        private List<Path> paths;
        private int to;

        private PathFinder(int from, int to) {
            this.paths = new ArrayList<>();
            this.to = to;
            goToNextCity(null, from);
        }

        private void goToNextCity(Path currentPath, int from) {
            for (Route route : getRoutesFrom(from)) {
                Path newPath = new Path(currentPath);

                if (route.endTo(to)) {
                    newPath.addRoute(route);
                    paths.add(newPath);
                    return;
                } else {
                    newPath.addRoute(route);
                    goToNextCity(newPath, route.getTo());
                }
            }
        }

        private List<Route> getRoutesFrom(int city) {
            return routes.stream()
                    .filter(route -> route.startsFrom(city))
                    .collect(Collectors.toList());
        }

        List<Path> getPaths() {
            return paths;
        }
    }
}
