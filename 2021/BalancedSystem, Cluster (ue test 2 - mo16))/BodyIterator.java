import java.util.NoSuchElementException;

// An iterator over elements of type 'Body'.
public interface BodyIterator extends java.util.Iterator<Body> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element (i.e. body) in the iteration.
    Body next() throws NoSuchElementException;

    /*
    Removes from the underlying collection the last element returned by this iterator.
    This method can be called only once per call to next().
    IllegalStateException - if the next method has not yet been called, or the remove method has already been
     called after the last call to the next method
    */
    void remove() throws IllegalStateException;
}