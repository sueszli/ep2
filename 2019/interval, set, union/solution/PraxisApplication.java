import java.util.Iterator;
import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Ordering within some outputs may differ from that of the given outputs.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplication {

    public static void main(String[] args) {

        Interval i1 = new Interval(0,5);
        System.out.println(i1); // 0-5

        System.out.println(i1.union(new Interval(3,8))); // 0-8
        System.out.println(i1.union(new Interval(7,8))); // [0-5, 7-8]
        System.out.println(i1.union(new Interval(6,8))); // 0-8

        Iterator<Integer> iter = i1.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next()+" ");
        }
        System.out.println();
        // 0 1 2 3 4 5

        try {
            iter.next();
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        // no element!

        Interval i2 = new Interval(7,10);
        Interval i3 = new Interval(12,15);

        Set set = i1.union(i2).union(i3).union(i3);
        System.out.println("set: " + set); // [0-5, 7-10, 12-15]
        set = set.union(new Interval(5,8));
        System.out.println(set); // [12-15, 0-10]

        for(int i: set) {
            System.out.print(i+" ");
        }
        // 12 13 14 15 0 1 2 3 4 5 6 7 8 9 10

        Union u = (Union) set;
        u.removeAllConnectedWith(new Interval(6,11));
        System.out.println();
        System.out.println("u: " + u);
    }
}

