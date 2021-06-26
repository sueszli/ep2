###Angabe

Gegeben ist folgendes Interface:

````
public interface Cluster extends BodyIterable {

    //adds the Cluster c to the cluster 'this' and returns the changed cluster 'this'
    Cluster add(Body c);

    //returns overall number of bodies in the cluster (and its sub-clusters)
    public int numberOfBodies();

    //returns the summed mass of all the bodies in the cluster (and it's sub-clusters)
    public double getMass();

}
````

Erstellen Sie eine neue Klasse `BalancedSystem`, die dieses Interface implementiert. Ein Objekt vom Typ `BalancedSystem` besteht dabei immer aus genau einem linken und rechten Cluster. Das Interface `Cluster` soll in `BalancedSystem` und `Body` implementiert werden. Die `add`-Methode hat als Nachbedingung zusätzlich die Zusicherung, dass die Differenz zwischen den Massen des linken und rechten Clusters kleiner ist als die Masse des hinzugefügten Bodies. Neue Bodies sollten somit immer zu dem Cluster hinzugefügt werden, der eine geringere Masse aufweist. 

Verwenden Sie bei der Implementierung von `BalancedSystem` folgendes Code-Gerüst: 

````
import java.io.IOException;

public class BalancedSystem implements Cluster {

    //TODO: define object variables

    //TODO: implement constructor
    //the constructor should throw a BalancedSystemIllegalArgumentException (to be implemented), if one of the arguments is null
    BalancedSystem(Cluster left, Cluster right) throws BalancedSystemIllegalArgumentException {

    }

    @Override
    //adds a Body b to the BalancedSystem. If the mass of the left cluster is less than the mass of the right cluster,
    //the body is added to the left cluster, otherwise to the right cluster.
    //Returns this after the operation
    public Cluster add(Body b) {
        //TODO
        return null;
    }

    @Override
    //returns overall number of bodies in the cluster (ans its sub-clusters)
    public int numberOfBodies() {
        //TODO
        return -1;
    }

    @Override
    //returns the summed mass of all the bodies in the cluster (ans its sub-clusters)
    public double getMass() {
        //TODO
        return -1.0;
    }

    @Override
    //returns an iterator over all bodies
    public BodyIterator iterator() {
        //TODO
        return null;
    }

    @Override
    //returns a String indicating the masses of the left and right subsystem
    //E.g., "Left mass: 10.0, right mass: 12.0
    public String toString() {
        //TODO
        return "";
    }
}

````

(Hinweis: `hashCode()` und `equals()` müssen nicht überschrieben werden)

Verwenden Sie die mitgelieferte Klasse `PraxisApplicationU8` zum Testen Ihrer Lösung.



