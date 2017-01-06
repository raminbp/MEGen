package com.rb.tree;

public class BinaryTree {


    private Node root;

    public Node getRoot() {
        return root;
    }


    /**
     *
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * @param data
     * @param key
     */
    public void insert(String data, int key) {
        Node newNode = new Node(data, key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (key < current.getKey()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    public void display(Node root) {
        if (root != null) {
            display(root.getLeft());
            System.out.print(" " + root.getKey());
            display(root.getRight());
        }
    }
}
