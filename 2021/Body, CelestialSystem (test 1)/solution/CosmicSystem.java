// This class represents a cosmic system, containing multiple bodies (objects of class 'Body').
// 'CosmicSystem' uses a linked list to store its bodies.

public class CosmicSystem {
    private LLNode root;
    private Body recentCollision;

    public CosmicSystem(){
    }

    // Adds 'b' to the end of the list of bodies if the list does not already contain a body
    // with the same position.
    // If the list already contains a body with the same position as 'b', this list entry is
    // replaced by a new body formed by the collision with 'b' (see method 'collideWith' in 'Body'),
    // i.e., the new body has the same index in the list as the replaced body.
    // Precondition: b != null.
    public void append(Body b) {
        if (root == null) root = new LLNode(b, null);
        else root.nodeAdd(b);
    }

    // Removes the body with the specified position from the list and returns it.
    // The method returns 'null' if no such body exits in the list.
    // Precondition: position != null.
    public Body remove(Vector3 position) {
        if (root == null) return null;

        //check root
        if (root.getVal().getPosition().equals(position)) {
            Body temp = root.getVal();
            root = root.getNext();
            return temp;
        } else {
            return root.removePos(position);
        }

        /*
        if (root.getVal().getPosition().equals(position)) {
            Body temp = root.getVal();
            root = root.getNext();
            return temp;
        } else {
            Body output = null;
            for (LLNode p = root; p != null; p = p.getNext()) {
                //iterate through all nodes
                boolean nextIsBad = p.getNext().getVal().getPosition().equals(position);
                if (nextIsBad) {
                    output = p.getNext().getVal();
                    LLNode nextnext = p.getNext().getNext();
                    if (nextnext == null) {
                        p.setNext(null);
                    } else {
                        p.setNext(nextnext);
                    }
                }
            }
            return output;
        }
         */
    }

    // Returns the body of this system that was most recently formed by a collision
    // (by the most recent call of 'add' that resulted in a collision) and returns it.
    // The method returns 'null' if no such body exits in the list.
    public Body getRecentCollision() {
        return recentCollision;
    }

    // Returns a new cosmic system containing the body with index 0 and the body with
    // the largest index (last entry) of this system in the same order.
    // If 'this' is empty, an empty system is returned.
    // If 'this' has only one body, a new system with the single body is returned.
    public CosmicSystem getFirstAndLast() {
        CosmicSystem output = new CosmicSystem();

        //no elems
        if (root == null) return output;

        Body first = root.getVal();
        Body last = root.nodeGetLastBody();

        if (first.getPosition().equals(last.getPosition())) {
            //one elem
            output.append(first);
            return output;
        } else {
            //multiple elems
            output.append(first);
            output.append(last);
            return output;
        }
    }

    // Returns a readable representation with each of the bodies of this cosmic system
    // in a separate line ordered by their list index.
    public String toString() {
        if (root == null) return "list is empty!";
        else return root.nodeToString();
    }

    class LLNode {
        private Body val;
        private LLNode next;

        public LLNode(Body val, LLNode next) {
            this.val = val;
            this.next = next;
        }

        public Body getVal() {
            return val;
        }

        public LLNode getNext() {
            return next;
        }

        public void nodeAdd(Body b){
            if (val.getPosition().equals(b.getPosition())){
                //equal -> collision
                val = val.collideWith(b);
                recentCollision = val;
            } else {
                //continue
                if(this.next != null){
                    this.next.nodeAdd(b);
                } else {
                    this.next = new LLNode(b, null);
                }
            }
        }

        public Body removePos(Vector3 v){
            if (next != null) {
                Vector3 nextPos = next.val.getPosition();
                if (nextPos.equals(v)){
                    Body temp = this.next.getVal();
                    this.next = next.next;
                    return temp;
                } else {
                    return this.next.removePos(v);
                }
            } else {
                return null;
            }
        }

        public Body nodeGetLastBody(){
            if (this.next != null) return next.nodeGetLastBody();
            else return this.val;
        }

        public String nodeToString(){
            return this.val.toString() + (next == null ? "" : "\n" + next.nodeToString());
        }
    }
}