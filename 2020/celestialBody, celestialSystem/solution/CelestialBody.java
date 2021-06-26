import java.util.Objects;

// This class represents celestial bodies like stars, planets, asteroids, etc..
public class CelestialBody {
    private String name;
    private double mass;

    // Initializes 'this' with name and mass.
    // Precondition: name != null.
    public CelestialBody(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CelestialBody that = (CelestialBody) o;
        return Double.compare(that.mass, mass) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mass);
    }

    @Override
    public String toString() {
        return name + ": " + mass;
    }
}

