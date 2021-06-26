public interface Cluster extends BodyIterable {

    //adds the Cluster c to the cluster 'this' and returns the changed cluster 'this'
    Cluster add(Body c) throws BalancedSystemIllegalArgumentException;

    //returns overall number of bodies in the cluster (and its sub-clusters)
    public int numberOfBodies();

    //returns the summed mass of all the bodies in the cluster (and it's sub-clusters)
    public double getMass();

}
