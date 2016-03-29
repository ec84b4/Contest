package ir.hister.contest.codechef.freeticket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/29/2016.
 *
 * @author Khaled Bakhtiari
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int cityCount = Integer.parseInt(firstLine[0]);
        int routeCount = Integer.parseInt(firstLine[1]);
        FreeTicket freeTicket = new FreeTicket(cityCount);
        for (int i = 0; i < routeCount; i++) {
            String[] line = reader.readLine().split(" ");
            freeTicket.addRoute(new Route(intMe(line[0]), intMe(line[1]), intMe(line[2])));
        }

        System.out.println(freeTicket.getLongestPath().getPrice());
    }

    private static int intMe(String s) {
        return Integer.parseInt(s);
    }
}
