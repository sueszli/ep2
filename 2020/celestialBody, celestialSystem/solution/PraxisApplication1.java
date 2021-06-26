// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplication1 {

    public static void main(String[] args) {

        CelestialBody sun, mercury, venus, earth, mars, anotherEarth;

        sun = new CelestialBody("Sol", 1.989e30);

        mercury = new CelestialBody("Mercury", 0.330114e23);

        venus = new CelestialBody("Venus", 4.86747e24);

        earth = new CelestialBody("Earth", 5.97237e24);

        mars = new CelestialBody("Mars", 0.641712e24);

        anotherEarth = new CelestialBody("Earth", 5.97237e24);

        CelestialSystem solarSystem = new CelestialSystem();
        System.out.println(solarSystem.add(sun)); // true
        System.out.println(solarSystem.add(mercury)); // true
        System.out.println(solarSystem.add(venus)); // true
        System.out.println(solarSystem.add(earth)); // true
        System.out.println(solarSystem.add(mars)); // true
        System.out.println(solarSystem.add(anotherEarth)); // false

        System.out.println(solarSystem.indexof("Venus")); // 4
        System.out.println(solarSystem.indexof("Earth")); // 0

        System.out.println(solarSystem.toString());
        /*
        Earth: 5.97237E24
        Mars: 6.41712E23
        Mercury: 3.30114E22
        Sol: 1.989E30
        Venus: 4.86747E24
        */

        System.out.println(solarSystem.size()); // 5

        System.out.println(solarSystem.get("Sol")); // Sol: 1.989E30
        System.out.println(solarSystem.indexof("Sol")); // 3

        System.out.println(solarSystem.indexof("Oumuamua")); // -1


    }
}
