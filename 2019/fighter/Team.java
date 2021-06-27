// A team consists of multiple fighters stored in a ring list (all nodes have a successor node != null).
// One fighter of the team is active and engages a one-on-one fight with the active fighter
// of the opponent team. After that, the next fighter becomes active in each team.
// TODO: define further classes for the implementation of the ring list, if needed (either in this file
// or in separate files)
//
public class Team {
    // TODO: declare variables
    // Initializes this team with the fighters from 'fighters' and sets the first
    // fighter in the list active.
    // Preconditions: fighters != null and has no entries equal to 'null' (need not
    // be checked).
    public Team(Fighter[] fighters) {
        // TODO: implement this constructor
    }

    // Simulates a one-on-one fight: the active fighter of this team fights
    // the active fighter of team 'opponent' by calling the method 'fight' of class
    // 'Fighter'.
    // Dead fighters are removed from their team (from the ring list) after
    // the one-on-one fight. After a fight, the next fighter becomes active in each
    // team.
    // If 'this' or 'opponent' is empty, calling this method has no effect.
    // Precondition: opponent != null (needs not be checked).
    public void fight(Team opponent) {
        // TODO: implement this method
    }

    // Returns 'true' if there is no fighter in the team.
    public boolean isEmpty() {
        // TODO: implement this method
        return false;
    }

    // Returns a representation of this team with all its (remaining) fighters in
    // brackets in order of their insertion. The active fighter is marked by '*'.
    // Returns "[]" if the team is empty.
    public String toString() {
        // TODO: implement this method
        return "";
    }
}