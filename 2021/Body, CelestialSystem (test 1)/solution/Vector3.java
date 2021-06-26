import java.util.Objects;

// This class represents vectors in a 3D vector space.
public class Vector3 {
    private int x;
    private int y;
    private int z;

    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Returns the sum of this vector and vector 'v'.
    public Vector3 plus(Vector3 v) {
        return new Vector3(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    // Returns the sum of this vector and -1*v.
    public Vector3 minus(Vector3 v) {
        return new Vector3(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    // Returns 'true' if 'this' is the zero vector.
    public boolean isZero() {
        return x == 0 && y == 0 && z == 0;
    }

    // Returns the coordinates of this vector in brackets as a string
    // in the form "<x;y;z>", e.g., "<5;-7;0>".
    public String toString() {
        return "<" + x + ";" + y + ";" + z + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 vector3 = (Vector3) o;
        return x == vector3.x && y == vector3.y && z == vector3.z;
    }
}

