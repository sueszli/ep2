// A celestial object that can be orbited or in orbit of other objects.
// Such a system has a recursive tree structure, i.e., it is composed of
// a central body and an arbitrary number of systems orbiting around it, each of
// them are themselves composed of a central body and an arbitrary number of systems,
// and so on. The classes 'CelestialSystem' and 'CelestialBody' implement 'Orbitable'.
//
// Example:
//
// Sun: 1.989E30 kg
//     Mercury: 3.30114E22 kg
//     Venus: 4.86747E24 kg
//     Earth: 5.97237E24 kg
//         Moon: 7.349E22 kg
//     Mars: 6.419E23 kg
//         Deimos: 1.8E15 kg
//         Phobos: 1.072E16 kg
//     Jupiter: 1.898E27 kg
//         Io: 8.9E22 kg
//         Ganymede: 1.5E23 kg
//         Kallisto: 1.1E23 kg
//         Europa: 4.8E22 kg
//         Metis: 1.2E17 kg
//
// In this example "Sun" is the name of the central body and there are five 'Orbitable' objects in
// orbit in the first level of the tree structure.
//
// The iterator of 'this' iterates over all "first-level" 'Orbitable' objects.
// In the above example this would be the 'Orbitable' objects: Mercury, Venus, Earth, Mars, Jupiter.
//
public interface Orbitable extends OrbitIterable {

    // Returns a readable representation of 'this' with the name of each body and its mass. Each
    // body is shown in a separate line. Each line has an indent to reflect the tree like
    // structure of the entire system (see the example above).
    String toString();

    // Returns the name of the central body of 'this'.
    String getName();

    // Returns a new system which is the result of inserting the specified subsystem into 'this'.
    // 'this' is not affected by this operation.
    Orbitable add(Orbitable inOrbit);

}
