// This class represents a cosmic system, containing multiple bodies (objects of class 'Body').
// 'CosmicSystem' uses a linked list to store its bodies.

public class CosmicSystem {
    public CosmicSystem(){
    }

    // Adds 'b' to the end of the list of bodies if the list does not already contain a body
    // with the same position.
    // If the list already contains a body with the same position as 'b', this list entry is
    // replaced by a new body formed by the collision with 'b' (see method 'collideWith' in 'Body'),
    // i.e., the new body has the same index in the list as the replaced body.
    // Precondition: b != null.
    public void append(Body b) {
    }

    // Removes the body with the specified position from the list and returns it.
    // The method returns 'null' if no such body exits in the list.
    // Precondition: position != null.
    public Body remove(Vector3 position) {
        return null;
    }

    // Returns the body of this system that was most recently formed by a collision
    // (by the most recent call of 'add' that resulted in a collision) and returns it.
    // The method returns 'null' if no such body exits in the list.
    public Body getRecentCollision() {
        return null;
    }

    // Returns a new cosmic system containing the body with index 0 and the body with
    // the largest index (last entry) of this system in the same order.
    // If 'this' is empty, an empty system is returned.
    // If 'this' has only one body, a new system with the single body is returned.
    public CosmicSystem getFirstAndLast() {
        return null;
    }

    // Returns a readable representation with each of the bodies of this cosmic system
    // in a separate line ordered by their list index.
    public String toString() {
        return null;
    }
}