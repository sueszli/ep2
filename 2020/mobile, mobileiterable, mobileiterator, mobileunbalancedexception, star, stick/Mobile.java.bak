// A mobile is a hanging room decoration consisting of sticks on whose left and right ends
// further mobiles are attached (recursive structure). The actual decorations (e.g. stars) are
// the leaf nodes. The numbers shown below correspond to the weights of
// sticks respectively stars.
//
//          |
//      +---2---+
//      |       |
//   +--2--+    *
//   |     |    16
//   *  +--1--+
//   7  |     |
//      *     *
//      3     3
//
// Readable representation as string: ((*7)-2-((*3)-1-(*3)))-2-(*16)
//
// A mobile is valid, if it is balanced, meaning left and right part weigh the same.
//
public interface Mobile extends MobileIterable {

    // Returns the total weight of this mobile (including all sticks and stars).
    int getWeight();


    // Returns a readable representation of the mobile, showing its complete
    // structure with all weights using an expression with parentheses.
    // Example (compare with the graphical representation above):
    // ((*7)-2-((*3)-1-(*3)))-2-(*16)
    String toString();

    // Returns 'true' if 'this' and 'o' are equal.
    // Two mobiles are equal if
    // 1.) they can be transferred into each other by exchanging the left and right part
    // (recursively on any of the levels),
    // 2.) corresponding parts have the same weight.
    // For example, all three of the following mobiles are equal:
    //
    //          |                      |                |
    //      +---2---+              +---2---+        +---2---+
    //      |       |              |       |        |       |
    //   +--2--+    *           +--2--+    *        *    +--2--+
    //   |     |    16          |     |    16       16   |     |
    //   *  +--1--+          +--1--+  *               +--1--+  *
    //   7  |     |          |     |  7               |     |  7
    //      *     *          *     *                  *     *
    //      3     3          3     3                  3     3
    //
    boolean equals(Object o);

    // Returns the hash code of 'this'.
    int hashCode();

}

