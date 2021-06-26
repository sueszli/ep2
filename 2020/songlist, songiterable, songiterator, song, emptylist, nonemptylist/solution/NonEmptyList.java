import java.util.NoSuchElementException;
import java.util.Objects;

// A song list with at least one entry. This song list is never empty.
//
public class NonEmptyList implements SongList {
    private Song val;
    private SongList next;

    // Initialises 'this'.
    // Precondition: song != null.
    public NonEmptyList(Song song) {
        this.val = song;
        this.next = EmptyList.EMPTY;
    }

    public NonEmptyList(Song val, SongList next){
        this.val = val;
        this.next = next;
    }

    //getVal()
    @Override
    public Song first() {
        return val;
    }

    //getNext()
    @Override
    public SongList afterFirst() {
        return next;
    }

    @Override
    public SongList add(Song song) {
        next = next.add(song);
        return this;
    }

    @Override
    public SongList remove(Song song) {
        if (this.val.equals(song)){
            return next.remove(song);
        } else {
            this.next = next.remove(song);
            return this;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        NonEmptyList other1 = (NonEmptyList) other;
        return this.containsAllSongs(other1) && other1.containsAllSongs(this);
    }

    private boolean containsAllSongs(NonEmptyList other){
        return other.containsSong(val) && (next == EmptyList.EMPTY || other.containsSong(next.first()));
    }

    private boolean containsSong(Song s){
        return this.val.equals(s) || next.first().equals(s);
    }

    @Override
    public int hashCode() {
        return val.hashCode() + next.hashCode();
    }

    @Override
    public String toString() {
        return this.val.toString() + (next == EmptyList.EMPTY ? "" : "\n" + next.toString());
    }

    @Override
    public SongIterator iterator() {
        NonEmptyList n = this;
        return new SongIterator() {
            private SongList pointer = n;

            @Override
            public boolean hasNext() {
                return pointer != EmptyList.EMPTY;
            }

            @Override
            public Song next() {
                if (!hasNext()) throw new NoSuchElementException("No such element!");
                Song temp = pointer.first();
                pointer = pointer.afterFirst();
                return temp;
            }
        };
    }
}
