package com.rb.operator;

import java.util.ArrayList;
import java.util.List;

import com.rb.tree.Node;

public class Binary extends Operator {

    protected String symbol;
    /**
     * @return
     */
    public List<Node> generateRandomChildren() {
        List<Node> children = new ArrayList<Node>();
        Node node = new Node();
        children.add(node.getARandomChild());
        children.add(node.getARandomChild());
        return children;
    }


    public String toString() {

        return getLeft().toString() + " " + getSymbol() + " " + getRight().toString();
    }
}
