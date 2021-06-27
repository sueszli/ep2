// This class represents a fighting character in a role playing game. Every
// fighter has a name and a number of hitpoints.
//
public class Fighter {
    // TODO: declare variables
    // A constructor with the 'name' of the fighter and his 'hitpoints'.
    public Fighter(String name, int hitpoints) {
        // TODO: implement this constructor
    }

    // Simulates a fight-to-the-death between 'this' and 'opponent'.
    // The fighter with more 'hitpoints' wins. His hitpoints are reduced
    // by the hitpoints of the losing fighter. The losing fighter is dead
    // after the fight (see method 'isDead').
    // In the case of equal hitpoints, both fighters are dead after the fight.
    // Precondition: opponent != null (needs not be checked).
    public void fights(Fighter opponent) {
        // TODO: implement this method
    }

    // Returns 'false' in the case of positive hitpoints, otherwise
    // it returns 'true'.
    public boolean isDead() {
        // TODO: implement this method
        return false;
    }

    // Returns a representation of this player with his name and his hitpoints in
    // parentheses. If this fighter is dead, hitpoints are 0.
    public String toString() {
        // TODO: implement this method
        return "";
    }
}