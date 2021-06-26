public interface SongList extends SongIterable {

    // Returns the first song of the list, or 'null' if 'this' is empty.
    Song first();

    // Returns the rest of the list (after the first song). Returns an 'EmptyList'
    // if 'this' has only one song.
    SongList afterFirst();

    // Returns a new 'SongList' with an entry 'song' at the end of the list.
    // The same song may be contained more than once in a song list.
    // Precondition: song != null.
    SongList add(Song song);

    // Returns a new 'SongList' with all songs equal to the specified song removed.
    // If 'song' is not contained in the list, the list remains unchanged (same list is returned).
    // Precondition: song != null.
    SongList remove(Song song);

    // Returns 'true' if this song list is equal to the specified object. Two song lists are
    // equal if they contain the same songs regardless how often and regardless of the
    // order in the list. For example [s1, s2, s3] is equal to [s3, s2, s3, s1] but not equal
    // to [s1, s2].
    boolean equals(Object o);

    // Returns the hash code of 'this'.
    int hashCode();

    // Returns a readable representation where each song is in a separate line. The songs are
    // in the order in which they have been added. The most recently added song is in the
    // last line.
    // If the list is empty, "no song" is returned.
    String toString();

    // Returns an iterator that iterates over all songs in the order in which they have been added.
    SongIterator iterator();

}

