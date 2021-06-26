import java.awt.*;

// This class represents vectors in a 3D vector space.
public class Vector3 {

    private double x;
    private double y;
    private double z;

    public Vector3(){}
    public Vector3(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    // Returns the sum of this vector and vector 'v'.
    public Vector3 plus(Vector3 v) {
        Vector3 output = new Vector3();
        output.x = this.x + v.x;
        output.y = this.y + v.y;
        output.z = this.z + v.z;
        return output;
    }

    // Returns the product of this vector and 'd'.
    public Vector3 times(double d) {
        Vector3 output = new Vector3();
        output.x = this.x * d;
        output.y = this.y * d;
        output.z = this.z * d;
        return output;
    }

    // Returns the sum of this vector and -1*v.
    public Vector3 minus(Vector3 v) {
        Vector3 output = new Vector3();
        output.x = this.x - v.x;
        output.y = this.y - v.y;
        output.z = this.z - v.z;
        return output;
    }

    // Returns the Euclidean distance of this vector
    // to the specified vector 'v'.
    public double distanceTo(Vector3 v) {
        double dX = this.x - v.x;
        double dY = this.y - v.y;
        double dZ = this.z - v.z;
        return Math.sqrt(dX * dX + dY * dY + dZ * dZ);
    }

    // Returns the length (norm) of this vector.
    public double length() {
        return this.distanceTo(new Vector3());
    }
    // Normalizes this vector: changes the length of this vector such that it becomes 1.
    // The direction and orientation of the vector is not affected.
    public void normalize() {
        double length = this.length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
    }

    // Returns the coordinates of this vector in brackets as a string
    // in the form "[x,y,z]", e.g., "[1.48E11,0.0,0.0]".
    public String toString() {
        return "[" + this.x + "," + this.y + "," + this.z + "]";
    }

}

