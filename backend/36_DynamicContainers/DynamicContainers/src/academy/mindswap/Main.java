package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        NodeContainer nodeContainer = new NodeContainer();

        nodeContainer.addNode();
        nodeContainer.addNode();

        nodeContainer.showChain();

        System.out.println("-----------------------------------------------");

        nodeContainer.removeNode(2);

        nodeContainer.showChain();

        System.out.println("-----------------------------------------------");

        nodeContainer.addNode(2);

        nodeContainer.showChain();
    }
}
