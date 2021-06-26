import java.util.Iterator;
public interface GradingIterator extends Iterator<Grading> {

    // Returns the next grading of the iteration. Throws a 'NoSuchElementException' with
    // an error message (see examples in 'PraxisApplication2.java') if the
    // iteration has no more gradings.
    Grading next();

    // Returns 'true' if the iteration has more gradings and 'false' otherwise.
    boolean hasNext();

}