package academy.mindswap;

import java.util.UUID;

public final class NodeContainer {
    Node head;
    int numberOfNodes;

    public NodeContainer() {
        head = new Node(UUID.randomUUID().toString(), null);

        numberOfNodes++;
    }

    public void addNode() {
        Node tempNode = head;

        while (tempNode.hasNextNode()) {
            tempNode = tempNode.nextNode;
        }

        tempNode.nextNode = new Node(UUID.randomUUID().toString(), null);

        numberOfNodes++;
    }

    public void addNode(int index) {
        if (index == 0 || index > numberOfNodes + 1) {
            System.out.printf("You can only add a new node between position 1 and %d.%n%n", numberOfNodes + 1);

            return;
        }

        Node previousTempNode = head;

        Node nextTempNode = previousTempNode.nextNode;

        int nodeCounter = 1;

        if (index == 1) {
            head = new Node(UUID.randomUUID().toString(), previousTempNode);

            previousTempNode.nextNode = nextTempNode;

            numberOfNodes++;

            return;
        }

        while (previousTempNode.hasNextNode()) {
            nodeCounter++;

            if (nodeCounter == index) {
                previousTempNode.nextNode = new Node(UUID.randomUUID().toString(), nextTempNode);

                numberOfNodes++;

                return;
            }

            previousTempNode = nextTempNode;

            nextTempNode = previousTempNode.nextNode;
        }

        previousTempNode.nextNode = new Node(UUID.randomUUID().toString(), null);

        numberOfNodes++;
    }

    public void showChain() {
        if (head == null) {
            System.out.println("There are no nodes.\n\n");

            return;
        }

        Node tempNextNode = head;

        while (tempNextNode.hasNextNode()) {
            System.out.println("node: " + tempNextNode.id);

            tempNextNode = tempNextNode.nextNode;

            System.out.println("next node: " + tempNextNode.id);
        }

        System.out.println("node: " + tempNextNode.id);

        System.out.println("next node: " + (tempNextNode.nextNode == null ? "null" : tempNextNode.nextNode.id));
    }
    
    public void removeNode(int index) {
        if (index > numberOfNodes) {
            System.out.printf("That node doesn't exist. There are only %d nodes.%n%n", numberOfNodes);

            return;
        }

        if (numberOfNodes == 1) {
            head = null;

            numberOfNodes--;

            return;
        }

        Node previousTempNode = head;

        Node nextTempNode = previousTempNode.nextNode;

        int nodeCounter = 1;

        if (index == 1) {
            head = nextTempNode;

            numberOfNodes--;

            return;
        }

        while (previousTempNode.hasNextNode()) {
            nodeCounter++;

            if (nodeCounter == index) {
                previousTempNode.nextNode = nextTempNode.nextNode;

                nextTempNode.nextNode = null;

                numberOfNodes--;

                return;
            }

            previousTempNode = nextTempNode;

            nextTempNode = previousTempNode.nextNode;
        }
    }
}
