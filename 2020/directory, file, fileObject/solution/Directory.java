import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

// A directory of file system objects. The iterator iterates over all
// direct entries of this directory (no recursive listing of the content of subdirectories).
// The size of a directory corresponds to the sum of the sizes of all entries.
//
public class Directory implements FileObject, FileObjectIterable {
    ArrayList<FileObject> list = new ArrayList<>();
    private final String name;

    public Directory(String name) {
        this.name = name;
    }

    // Adds 'fso' to this directory, if it does not already have
    // an entry equal to 'fso'. Returns 'true' if 'this' was changed as
    // a result of the call and else otherwise.
    public boolean add(FileObject fso) {
        if (list.contains(fso)) return false;
        return list.add(fso);
    }

    // Returns a string with the recursive directory tree, i.e., listing its name and size, each
    // entry with name and size in a separate line and recursively all
    // subdirectories.
    // An indent is used to visualize the tree structure.
    // Example:
    // Documents 217
    //     Description.txt 120
    //     Programs 78
    //         Bomb.sh 13
    //         Hello.java 65
    //     Test.md 21
    public String toString() {
        String output = name + " " + getSize();
        for (FileObject fo : list) {
            String[] lines = fo.toString().split("\n");
            for (String line : lines) {
                output += "\n\t" + line;
            }
        }
        return output;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (FileObject fo : list) sum += fo.getSize();
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FileObject)) return false;
        FileObject file = (FileObject) o;
        return Objects.equals(name, file.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public FileObjectIterator iterator() {
        Iterator<FileObject> iter = list.iterator();
        return new FileObjectIterator() {
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public FileObject next() {
                if (!hasNext()) throw new NoSuchElementException("Directory has no more entries!");
                return iter.next();
            }
        };
    }
}

