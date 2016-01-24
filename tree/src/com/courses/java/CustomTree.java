package com.courses.java;

public class CustomTree {

    Node root;

    public void addNode(int key, String value) {
        Node node = new Node(key, value);

        if (root == null) {
            root = node;
            return;
        }

        Node currentNode = root;
        Node parent;

        while (true) {
            parent = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
                if (currentNode == null) {
                    parent.leftChild = node;
                    return;
                }
            } else {
                currentNode = currentNode.rightChild;
                if (currentNode == null) {
                    parent.rightChild = node;
                    return;
                }
            }
        }
    }

    public Node findNode(int key) {
        if (root == null) {
            return null;
        }

        Node currentNode = root;
        while (currentNode.key != key) {
            if (key < currentNode.key)
                currentNode = currentNode.leftChild;
            else
                currentNode = currentNode.rightChild;

            if (currentNode == null) {
                return null;
            }
        }

        return currentNode;
    }

    public void traverse(Node currentNode) {
        if (currentNode != null) {
            traverse(currentNode.leftChild);
            System.out.println(currentNode.key + " - " + currentNode.value);
            traverse(currentNode.rightChild);
        }
    }

    public static void main(String[] args) {
        CustomTree tree = new CustomTree();
        tree.addNode(19, "Dog");
        tree.addNode(5, "Cat");
        tree.addNode(24, "Cat");
        tree.addNode(3, "Duck");
        tree.addNode(7, "Turtle");

        tree.traverse(tree.root);
    }

    class Node {
        int key;
        String value;

        Node leftChild;
        Node rightChild;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

}
