import java.util.Objects;

// This class represents a fighting character in a role playing game. Every
// fighter has a name and a number of hitpoints.
//
public class Fighter {
    private String name;
    private int hitpoints;

    // A constructor with the 'name' of the fighter and his 'hitpoints'.
    public Fighter(String name, int hitpoints) {
        this.name = name;
        this.hitpoints = hitpoints;
    }

    // Simulates a fight-to-the-death between 'this' and 'opponent'.
    // The fighter with more 'hitpoints' wins. His hitpoints are reduced
    // by the hitpoints of the losing fighter. The losing fighter is dead
    // after the fight (see method 'isDead').
    // In the case of equal hitpoints, both fighters are dead after the fight.
    // Precondition: opponent != null (needs not be checked).
    public void fights(Fighter opponent) {
        int damage = Math.min(this.hitpoints, opponent.hitpoints);
        this.hitpoints -= damage;
        opponent.hitpoints -= damage;
    }

    // Returns 'false' in the case of positive hitpoints, otherwise
    // it returns 'true'.
    public boolean isDead() {
        return hitpoints == 0;
    }

    // Returns a representation of this player with his name and his hitpoints in
    // parentheses. If this fighter is dead, hitpoints are 0.
    public String toString() {
        return name + "(" + hitpoints + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighter = (Fighter) o;
        return hitpoints == fighter.hitpoints && Objects.equals(name, fighter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hitpoints);
    }
}