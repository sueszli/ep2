import java.util.NoSuchElementException;

public class BasicIter implements PaintIterator {
    private Basic b;
    private boolean called;

    public BasicIter(Basic b) {
        this.b = b;
    }

    @Override
    public boolean hasNext() {
        return !called;
    }

    @Override
    public Basic next() {
        if (!hasNext()) throw new NoSuchElementException("called next() in BasicIter while hasNext() was false!");
        called = true;
        return b;
    }
}
