import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// A celestial system implements 'Orbitable' and has at least one object in orbit around its
// central celestial body. Further objects can be added.
//
public class CelestialSystem implements Orbitable {
    private final CelestialBody center;
    private final ArrayList<Orbitable> children;

    // Initialises this system with its central body.
    public CelestialSystem(CelestialBody centralBody, Orbitable inOrbit) {
        this.center = centralBody;
        this.children = new ArrayList<>();
        this.children.add(inOrbit);
    }

    public CelestialSystem(CelestialBody centralBody, ArrayList<Orbitable> children){
        this.center = centralBody;
        this.children = children;
    }

    @Override
    public OrbitIterator iterator() {
        return new OrbitIterator() {
            private final Iterator<Orbitable> iter = children.iterator();

            @Override
            public boolean hasNext() { return iter.hasNext(); }

            @Override
            public Orbitable next() {
                if (!hasNext()) throw new NoSuchElementException("No such element!");
                return iter.next();
            }
        };
    }

    @Override
    public String getName() { return center.getName(); }

    @Override
    public Orbitable add(Orbitable inOrbit) {
        CelestialBody centerCopy = new CelestialBody(center.getName(), center.getMass());
        ArrayList<Orbitable> childrenCopy = (ArrayList<Orbitable>) children.clone();
        childrenCopy.add(inOrbit);
        return new CelestialSystem(centerCopy, childrenCopy);
    }

    @Override
    public String toString() {
        String s = center.toString();
        for(Orbitable child : this) {
            /*
            s += Arrays.stream(child.toString().split("\n"))
                    .reduce("", (cs, ts) -> cs + "\n\t"  + ts); //works like foldl from haskell
             */
            String[] lines = child.toString().split("\n");
            for (String line : lines) {
                s += "\n\t" + line;
            }
        }
        return s;
    }
}

