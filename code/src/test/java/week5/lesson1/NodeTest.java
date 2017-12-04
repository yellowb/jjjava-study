package week5.lesson1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NodeTest {

    @Test
    public void test_node_should_be_comparable() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        List<Node> nodes = new ArrayList<Node>();
        nodes.add(n2);
        nodes.add(n1);
        nodes.add(n3);
        Collections.sort(nodes);

        assertEquals("Node is not comparable.", nodes.toString(), "[1, 2, 3]");
    }

}
