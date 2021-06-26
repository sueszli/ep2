import java.util.Objects;

// This class represents a cosmic body with mass and position.
public class Body {

    // A constructor initializing this body with mass and position.
    // Precondition: position != null.
    public Body(double mass, Vector3 position) {
    }

    // Returns 'null' if this body and 'b' is not at the same position.
    // Otherwise the new body formed by the collision of 'this' and 'b' is returned.
    // This new body has the same position as 'this' (and thus the same position as 'b')
    // and a mass that corresponds to the sum of the masses of the two colliding bodies.
    // Precondition: b != null.
    public Body collideWith(Body b) {
        return null;
    }

    // Returns the position of this body.
    public Vector3 getPosition() {
        return null;
    }

    // Returns a readable representation with mass and position, e.g. of the form
    // "10.34 <5;-2;20>".
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}




