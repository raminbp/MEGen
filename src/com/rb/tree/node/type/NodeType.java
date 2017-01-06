package com.rb.tree.node.type;


import com.rb.operand.Operand;
import com.rb.operator.Operator;

public enum NodeType {
    OPERAND(Operand.class),
    OPERATOR(Operator.class);

    public final Class<?> klass;

    private NodeType(Class<?> klass) {
        this.klass = klass;
    }
}
