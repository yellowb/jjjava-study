package week6.lesson2;

/**
 * Created by HUANGYE2 on 12/5/2017.
 */
public class AVLNode<T extends Comparable<T>> {

    public T data;

    public int depth;

    public int balance;

    public AVLNode parent;

    public AVLNode left;

    public AVLNode right;

    public AVLNode(T data) {
        this.data = data;
        this.depth = 1;
        this.balance = 0;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}
