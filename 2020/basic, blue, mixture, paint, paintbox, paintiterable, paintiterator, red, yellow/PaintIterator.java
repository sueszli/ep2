import java.util.Iterator;

// An iterator over all 'Basic' objects.
public interface PaintIterator extends Iterator<Basic> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements.
    Basic next();

}