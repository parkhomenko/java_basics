public class CustomLinkedList {

    private Node firstNode;
    private Node lastNode;

    private class Node {
        String value;
        Node next;
    }

    public void add(String value) {
        Node node = new Node();
        node.value = value;
        node.next = null;

        if (lastNode != null) {
            lastNode.next = node;
        }

        lastNode = node;

        if (firstNode == null) {
            firstNode = node;
        }
    }

    public void introduceCycle(int nodeIndex) {
        int currentIndex = 1;
        Node currentNode = firstNode;
        while (currentNode != null && currentIndex < nodeIndex) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        lastNode.next = currentNode;
    }

    public void output() {
        Node currentNode = firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public boolean hasLoop() {
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");

        list.output();

        list.introduceCycle(3);

        if (list.hasLoop()) {
            System.out.println("This linked list has an infinite loop");
        }
    }

}
