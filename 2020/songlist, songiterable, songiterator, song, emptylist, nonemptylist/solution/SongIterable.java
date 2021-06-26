public interface SongIterable extends Iterable<Song> {

    // Returns an iterator over songs.
    SongIterator iterator();

}
