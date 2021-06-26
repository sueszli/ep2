// Do not change this interface definition.
//
// Represents a painting color which is either a basic color or a mix of
// colors.
//
public interface Paint extends PaintIterable {

    // Returns an iterator over all basic colors of the paint.
    // The 'next' method throws a 'java.util.NoSuchElementException' if the iteration
    // has no more elements.
    PaintIterator iterator();

    // Returns 'true' if painting colors represented by 'this' and 'o' are equal. Colors are equal
    // if they contain the same basic colors.
    boolean equals(Object o);

    // Returns a new 'Paint' object, which contains the basic colors of 'this' and 'paint'.
    Paint mixWith(Paint paint);

    // Returns the hashCode of 'this'.
    int hashCode();

    // Returns a string representation of the 'this', listing its basic colors.
    String toString();
}


