package com.rb.tree;

import com.rb.operand.Operand;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.*;

public class Node {
    private String data;
    private int key;
    private Node left;
    private Node right;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    public Node(String data, int key) {
        this.data = data;
        this.key = key;
        left = null;
        right = null;
    }

    public Node() {
    }




    /**
     * @return
     */
    public List<Node> getAllSubTypes() {
        Class cls = this.getClass();
        Reflections reflections = new Reflections("com.rb");
        Set<Class<? extends Node>> nodeSubTypes = reflections.getSubTypesOf(Node.class);
        List<Node> result = new ArrayList<Node>();

        for (Iterator<Class<? extends Node>> it = nodeSubTypes.iterator(); it.hasNext(); ) {
            Class<? extends Node> cl = it.next();
            if (cl.getSuperclass().getName() == cls.getName()) {
                try {
                    Node clObject = (Node) Class.forName(cl.getName()).newInstance();
                    result.add(clObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

        return result;
    }


    /**
     * @return
     */
    public Node getARandomTypeOfSubTypes() {
        List<Node> subTypes = this.getAllSubTypes();
        int size = subTypes.size();
        if (size == 0) {
            return null;
        }
        return subTypes.get((int) Math.floor(Math.random() * size));
    }

    /**
     * @return empty set
     */
    public List<Node> generateRandomChildren() {
        List<Node> children = new ArrayList<Node>();
        return children;
    }


    /**
     * @return
     */
    public Node getARandomChild() {
        Node node = new Node();
        Node lastSubType = null;

        Node subType = node.getARandomTypeOfSubTypes();

        while (subType != null) {
            try {
//                subTypeInstance = (Node)Class.forName(subType.getName()).newInstance();
                lastSubType = subType;
                subType = subType.getARandomTypeOfSubTypes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lastSubType;
    }

    public String toString() {
        return "Undefined";
    }
}
