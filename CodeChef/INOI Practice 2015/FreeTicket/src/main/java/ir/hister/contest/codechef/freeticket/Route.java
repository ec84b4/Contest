package ir.hister.contest.codechef.freeticket;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/29/2016.
 *
 * @author Khaled Bakhtiari
 */
public class Route {
    private int from;
    private int to;
    private int price;

    public Route(int from, int to, int price) {
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Route))
            return false;

        Route r = (Route) obj;

        return price == r.price && (from == r.from || from == r.to) && (to == r.to || to == r.from);
    }

    @Override
    public String toString() {
        return from + "-" + to + "=" + price;
    }

    public boolean startsFrom(int city) {
        return from == city;
    }

    public boolean endTo(int city) {
        return to == city;
    }
}