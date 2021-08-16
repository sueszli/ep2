import java.util.*;

// 'Union' implements 'Set' and represents a union of multiple (at least two) unconnected intervals.
// Hint: It is allowed to use the java Collection-framework for the implementation (e.g., List<Interval>).
public class Union implements Set {
    ArrayList<Interval> list = new ArrayList<>();

    public Union(Interval a, Interval b) {
        if (a.isConnected(b)) { list.add((Interval) a.union(b)); }
        else { list.add(a); list.add(b); }
    }

    // Helper method: Removes all intervals from this 'Union' which are connected to 'other'
    // (i.e., intervals where the union with 'other' is a single continuous interval).
    // The union of all the removed intervals and 'other' is returned.
    // Precondition: other != null.
    public Interval removeAllConnectedWith(Interval other) {
        ArrayList<Interval> cs = new ArrayList<>();
        //get all connected elems
        for (Interval elem: list) {
            if (elem.isConnected(other)) cs.add(elem);
        }

        //remove from 'list', add to sum
        Interval sum = other;
        for (Interval c : cs){
            list.remove(c);
            sum = (Interval) sum.union(c);
        }
        return sum;
    }

    @Override
    public boolean isContinuous() {
        return list.size() == 1;
    }

    //add to list
    @Override
    public Set union(Interval other) {
        list.add(removeAllConnectedWith(other));
        if (this.isContinuous()) return list.get(0);
        return this;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Interval> listIter = list.iterator();
        return new Iterator<>() {
            private Iterator<Integer> intIter = listIter.next().iterator();

            @Override
            public boolean hasNext() { return intIter.hasNext() || listIter.hasNext(); }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException("No element!");
                if (intIter.hasNext()) return intIter.next();
                intIter = listIter.next().iterator();
                return intIter.next();
            }
        };
    }

    @Override
    public String toString() {
        String s = "";
        if (list.isEmpty()) return "[]";
        for (Interval elem: list) s += elem.toString() + ", ";
        return "[" + s.substring(0,s.length()-2) + "]";
    }
}

