import java.io.IOException;
import java.util.NoSuchElementException;

public class BalancedSystem implements Cluster {

    //the constructor should throw a BalancedSystemIllegalArgumentException (to be implemented), if one of the arguments is null
    BalancedSystem(Cluster left, Cluster right) throws BalancedSystemIllegalArgumentException {
    }

    @Override
    //adds a Body b to the BalancedSystem. If the mass of the left cluster is less than the mass of the right cluster,
    //the body is added to the left cluster, otherwise to the right cluster.
    //Returns this after the operation
    public Cluster add(Body b) throws BalancedSystemIllegalArgumentException {
        return null;
    }

    @Override
    //returns overall number of bodies in the cluster (and its sub-clusters)
    public int numberOfBodies() {
        return 0;
    }

    @Override
    //returns the summed mass of all the bodies in the cluster (ans its sub-clusters)
    public double getMass() {
        return 0.0;
    }

    @Override
    //returns an iterator over all bodies
    public BodyIterator iterator() {
        return null;
    }

    @Override
    //returns a String indicating the masses of the left and right subsystem
    //E.g., "Left mass: 10.0, right mass: 12.0
    public String toString() {
        return null;
    }
}