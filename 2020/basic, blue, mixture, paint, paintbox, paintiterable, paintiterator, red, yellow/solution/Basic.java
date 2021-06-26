// A basic painting color.
public interface Basic extends Paint {

    // Returns an iterator whose 'next' method returns 'this' when called for the first time.
    // Afterwards the iterator is consumed and has no more elements.
    PaintIterator iterator();

    // Returns 'true' if painting colors represented by 'this' and 'o' are equal,
    // in the case of the basic color this means, it returns 'true' if and only if
    // 'o' is of the same class as 'this' (same basic color).
    boolean equals(Object o);

}

