public interface PaintIterable extends Iterable<Basic> {

    // Returns an iterator over all basic colors ('Basic' objects) of the paint.
    PaintIterator iterator();

}

