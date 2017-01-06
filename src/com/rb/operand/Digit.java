package com.rb.operand;

import com.rb.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class Digit extends Operand {

    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    public String toString() {
        return Double.toString(getValue());
    }

    public List<Node> generateRandomChildren() {
        setValue(Math.random() * 1000);
        List<Node> children = new ArrayList<Node>();
        return children;
    }
}
