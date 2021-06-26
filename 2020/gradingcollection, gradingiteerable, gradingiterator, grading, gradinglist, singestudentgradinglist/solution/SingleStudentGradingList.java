import java.util.*;

// This class implements 'GradingCollection' and represents a list of gradings of a single student, i.e.,
// all gradings in this list must have an equal 'matriculationID'.
// The entries are in order in which they have been added.
// (The most recently added element is the last element of the list.)
// Iterator and 'toString' follow that order.
public class SingleStudentGradingList implements GradingCollection {
    private final int matriculationID;
    private ArrayList<Grading> gs = new ArrayList<>();

    private SingleStudentGradingList(int id, ArrayList<Grading> gs){
        this.matriculationID = id;
        this.gs = gs;
    }

    // Initializes this list with the 'matriculationID' of the student.
    public SingleStudentGradingList(int matriculationID) {
        this.matriculationID = matriculationID;
    }

    // Ensures that this list contains the specified 'grading', if the grading belongs to the student of this list.
    // If this list already contains the specified 'grading' or the grading does not belong to this
    // student, this list is not changed.
    public boolean add(Grading grading) {
        if (!(this.matriculationID == grading.getMatriculationID()) || gs.contains(grading)) return false;
        gs.add(grading); return true;
    }

    // If the specified 'matriculationID' is the same as that of this list, a copy of this list is returned,
    // otherwise an empty list is returned (with the specified 'matriculationID').
    public SingleStudentGradingList filter(int matriculationID) {
        if (this.matriculationID == matriculationID)
            return new SingleStudentGradingList(this.matriculationID, (ArrayList<Grading>) gs.clone());
        else return new SingleStudentGradingList(this.matriculationID);
    }

    @Override
    // Returns a representation with the matriculationID of the student and all the gradings.
    public String toString() {
        String out = "";
        for (Grading g: gs) out += g + "\n";
        return out;
    }

    @Override
    public GradingIterator iterator() {
        return new GradingIterator() {
            private Iterator<Grading> iter = gs.iterator();

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
}