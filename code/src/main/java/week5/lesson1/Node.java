package week5.lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static week5.lesson1.Node.NodeState.NOOP;

/**
 * Tree node
 *
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<Node> {

    public T data;

    public Node left;

    public Node right;

    public NodeState state;

    public Node(T d) {
        this.data = d;
        this.state = NOOP;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public int compareTo(Node o) {
        return this.data.compareTo((T) o.data);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        List<Node> l = new ArrayList<Node>();
        l.add(n2);
        l.add(n1);
        l.add(n3);
        Collections.sort(l);

        System.out.println(l);
    }

    /**
     * Node states to support traversing BST without recursive
     */
    enum NodeState {
        NOOP, SELF, LEFT, RIGHT
    }
}
