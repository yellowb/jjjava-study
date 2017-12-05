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

    /**
     * Node states to support traversing BST without recursive
     */
    enum NodeState {
        NOOP, SELF, LEFT, RIGHT, END
    }
}
