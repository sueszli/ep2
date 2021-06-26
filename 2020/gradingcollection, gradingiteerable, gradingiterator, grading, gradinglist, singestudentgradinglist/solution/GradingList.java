import java.util.*;

// This class implements the interface 'GradingCollection' and represents a list of gradings
// in order in which they have been added. (The most recently added element is the last element of the list.)
// Iterator and 'toString' follow that order.
// There are no duplicate entries.
public class GradingList implements GradingCollection {
    ArrayList<Grading> list = new ArrayList<>();

    @Override
    public boolean add(Grading grading) {
        if (list.contains(grading)) return false;
        list.add(grading);
        return true;
    }

    @Override
    public SingleStudentGradingList filter(int matriculationID) {
        SingleStudentGradingList gs = new SingleStudentGradingList(matriculationID);
        for (Grading g : list) gs.add(g);
        return gs;
    }

    @Override
    public GradingIterator iterator() {
        return new GradingIterator() {
            private final Iterator<Grading> iter = list.iterator();

            @Override
            public Grading next() {
                if(!hasNext()) throw new NoSuchElementException("Kein Zeugnis verfügbar!");
                else return iter.next();
            }

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }
        };
    }

    @Override
    public String toString() {
        String out = "";
        for (Grading g: list) out += g + "\n";
        return out;
    }
}