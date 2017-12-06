package week6.lesson2;

import static week6.lesson2.AVLNode.NodeState.NOOP;

/**
 * Created by HUANGYE2 on 12/5/2017..
 */
public class AVLNode<T extends Comparable<T>> {

    public T data;

    public int depth;

    public int balance;

    public AVLNode parent;

    public AVLNode left;

    public AVLNode right;

    public NodeState state;

    public AVLNode(T data) {
        this.data = data;
        this.depth = 1;
        this.balance = 0;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.state = NOOP;
    }

    /**
     * Node states to support traversing BST without recursive
     */
    enum NodeState {
        NOOP, SELF, LEFT, RIGHT, END
    }
}
