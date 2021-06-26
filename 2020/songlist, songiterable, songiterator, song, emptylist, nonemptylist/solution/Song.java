import java.util.Objects;

// A Song with a name (String) and duration in seconds (int).
//
public class Song {
    private String name;
    private int duration;

    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return duration == song.duration && Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    @Override
    public String toString() {
        return name + ", " + duration;
    }
}
