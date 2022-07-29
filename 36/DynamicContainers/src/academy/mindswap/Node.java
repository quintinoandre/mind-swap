package academy.mindswap;

public class Node {
    String id;
    Node nextNode;

    public Node(String id, Node nextNode) {
        this.id = id;
        this.nextNode = nextNode;
    }

    public boolean hasNextNode() {
        return nextNode != null;
    }
}
