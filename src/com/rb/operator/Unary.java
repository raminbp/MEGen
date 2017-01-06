package com.rb.operator;

import java.util.ArrayList;
import java.util.List;
import com.rb.tree.Node;

public class Unary extends Operator {


    /**
     *
     * @return
     */
    public List<Node> generateRandomChildren() {
        List<Node> children = new ArrayList<Node>();
        Node node = new Node();
        children.add(node.getARandomChild());
        return children;
    }

    public String toString() {
        return  getSymbol() + "( " + getLeft().toString() + " )";
    }

}
