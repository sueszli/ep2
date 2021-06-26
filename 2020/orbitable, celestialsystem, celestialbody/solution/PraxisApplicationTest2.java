import java.util.Arrays;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
public class PraxisApplicationTest2 {

    public static void main(String[] args) {

        Orbitable sun = null, jupiter, io, europa, ganymede, kallisto, metis, earth, moon, mars,
                phobos, deimos, mercury, venus;

        sun = new CelestialBody("Sun", 1.989e30);

        jupiter = new CelestialBody("Jupiter", 1.898e27);
        io = new CelestialBody("Io", 8.9e22);
        europa = new CelestialBody("Europa", 4.8e22);
        ganymede = new CelestialBody("Ganymed", 1.5e23);
        kallisto = new CelestialBody("Kallisto", 1.1e23);
        metis = new CelestialBody("Metis", 1.2e17);
        earth = new CelestialBody("Earth", 5.97237e24);
        moon = new CelestialBody("Moon", 7.349e22);
        mars = new CelestialBody("Mars", 6.419e23);
        phobos = new CelestialBody("Phobos", 1.072e16);
        deimos = new CelestialBody("Deimos", 1.8e15);
        mercury = new CelestialBody("Mercury", 0.330114e23);
        venus = new CelestialBody("Venus", 4.86747e24);

        jupiter = jupiter.add(io);
        jupiter = jupiter.add(europa);
        jupiter = jupiter.add(ganymede);
        jupiter = jupiter.add(kallisto);
        jupiter = jupiter.add(metis);

        earth = earth.add(moon);

        mars = mars.add(phobos);
        mars = mars.add(deimos);

        sun = sun.add(mercury);
        sun = sun.add(venus);
        sun = sun.add(earth);
        sun = sun.add(mars);
        sun = sun.add(jupiter);

        System.out.println(sun);


        /*
        Sun: 1.989E30 kg
            Mercury: 1.898E27 kg
            Venus: 4.86747E24 kg
            Earth: 5.97237E24 kg
                Moon: 7.349E22 kg
            Mars: 6.419E23 kg
                Deimos: 1.8E15 kg
                Phobos: 1.072E16 kg
            Jupiter: 1.898E27 kg
                Io: 8.9E22 kg
                Ganymede: 1.5E23 kg
                Kallisto: 1.1E23 kg
                Europa: 4.8E22 kg
                Metis: 1.2E17 kg

         */

        System.out.println();

        for (Orbitable o: sun) {
            System.out.println(o.getName());
        }
        /*
        Mercury
        Venus
        Earth
        Mars
        Jupiter
        */

        String[] arr = "Ganymede: 1.5E23 kg".split("\n");
        System.out.println(arr.length);
        for (String str : arr) {
            System.out.println(str);
        }

    }
}
