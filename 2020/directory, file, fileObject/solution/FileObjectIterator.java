import java.util.Iterator;

// An iterator over 'FileObject' objects.
public interface FileObjectIterator extends Iterator<FileObject> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements.
    FileObject next();

}
