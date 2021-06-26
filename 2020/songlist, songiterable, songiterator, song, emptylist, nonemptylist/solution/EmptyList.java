import java.util.NoSuchElementException;

// Represents an empty song list.
//
// 'add' returns a 'NonEmptyList'.
//
public class EmptyList implements SongList {

    // only one instance is needed.
    public static final EmptyList EMPTY = new EmptyList();

    private EmptyList() {} // may be changed to public, if needed (depending on your solution).

    @Override
    public Song first() {
        return null;
    }

    @Override
    public SongList afterFirst() {
        return null;
    }

    @Override
    public SongList add(Song song) {
        return new NonEmptyList(song);
    }

    @Override
    public SongList remove(Song song) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == EMPTY;
    }

    @Override
    public int hashCode() {
        return 1337;
    }

    @Override
    public String toString() {
        return "no song";
    }

    @Override
    public SongIterator iterator() {
        return new SongIterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Song next() {
                throw new NoSuchElementException("No such element!");
            }
        };
    }
}
