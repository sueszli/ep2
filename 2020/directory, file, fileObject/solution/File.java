import java.util.Objects;

// This class represents a single file. The size of a file corresponds
// to the length of its content.
//
public class File implements FileObject {
    private final String name;
    private final String content;

    // Constructor: initializes this file with a name and its content.
    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() { return name + " " + getSize();}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return content.length();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FileObject)) return false;
        FileObject file = (FileObject) o;
        return Objects.equals(name, file.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, content);
    }
}

