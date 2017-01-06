
import com.rb.tree.Node;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class main {


    /**
     *
     * @return
     */
    public static Node generateInitNode () {
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

    /**
     *
     * @param node
     */
    public static void generateTree (Node node) {
        int size;
        List<Node> children = node.generateRandomChildren();
        Node child1;
        Node child2;

        size = children.size();
        if (size == 1) {
            child1 = children.get(0);
            node.setLeft(child1);
            generateTree(child1);
        } else if (size == 2) {
            child1 = children.get(0);
            child2 = children.get(1);
            node.setLeft(child1);
            node.setRight(child2);

            generateTree(child1);
            generateTree(child2);
        } else {
            return;
        }

    }


    public static void main (String args[]) {

        for (int i = 0; i < 30; i++) {
            Node node = generateInitNode();
            generateTree(node);
            System.out.println(node.toString());
        }
    }
}
