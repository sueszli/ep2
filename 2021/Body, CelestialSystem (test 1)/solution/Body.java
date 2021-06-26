import java.util.Objects;

// This class represents a cosmic body with mass and position.
public class Body {
    private double mass;
    private Vector3 position;

    // A constructor initializing this body with mass and position.
    // Precondition: position != null.
    public Body(double mass, Vector3 position) {
        assert position != null;
        this.mass = mass;
        this.position = position;
    }

    // Returns 'null' if this body and 'b' is not at the same position.
    // Otherwise the new body formed by the collision of 'this' and 'b' is returned.
    // This new body has the same position as 'this' (and thus the same position as 'b')
    // and a mass that corresponds to the sum of the masses of the two colliding bodies.
    // Precondition: b != null.
    public Body collideWith(Body b) {
        assert b != null;
        if (!this.position.equals(b.position)) return null;
        else return new Body(this.mass + b.mass, this.position);
    }

    // Returns the position of this body.
    public Vector3 getPosition() {
        return this.position;
    }

    // Returns a readable representation with mass and position, e.g. of the form
    // "10.34 <5;-2;20>".
    public String toString() {
        return this.mass + " " + this.position.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return body.mass == mass && position.equals(body.position);
    }
}




