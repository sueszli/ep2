public interface GradingCollection extends GradingIterable {

    // Ensures that this collection contains the specified 'grading'. If this collection already contains the
    // specified 'grading', this collection is not changed. Returns 'true' if this collection changed as a result of
    // the call and 'false' otherwise.
    // Precondition: grading != null
    boolean add(Grading grading);

    // Returns a new collection that contains all entries of 'this' that belong to
    // a specified student.
    SingleStudentGradingList filter(int matriculationID);

    // Returns a string representation with all gradings of the collection.
    String toString();

}

