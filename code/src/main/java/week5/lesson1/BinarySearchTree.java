package week5.lesson1;

import java.util.Queue;
import java.util.LinkedList;

import week2.lesson3.GoodStack;

import static java.lang.System.*;
import static week5.lesson1.Node.NodeState.*;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    /**
     * Insert a node into BST
     *
     * @param i
     */
    public void insert(T i) {
        if (root == null) {
            root = new Node(i);
            return;
        }

        Node current = root;
        while (true) {
            // i is smaller than current node.
            if (i.compareTo((T) current.data) < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(i);
                    current.left.parent = current;  // set parent
                    break;
                }
            } else {
                if (current.right != null)
                    current = current.right;
                else {
                    current.right = new Node(i);
                    current.right.parent = current; // set parent
                    break;
                }
            }
        }
        return;
    }

    /**
     * Return true if BST contains input node.
     *
     * @param i
     * @return
     */
    public boolean contains(T i) {
        if (root == null) {
            return false;
        }

        Node<T> current = root;
        boolean found = false;

        while (true) {
            // i is smaller than current node.
            if (i.compareTo(current.data) == 0) {
                found = true;
                break;
            } else if (i.compareTo(current.data) < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    break;
                }
            }
        }
        return found;
    }

    /**
     * Pre-Order go through BST
     */
    public void preOrderWithRecursive() {
        preOrderWithRecursive(root);
    }

    public void preOrderWithRecursive(Node<T> current) {
        if (current == null) {
            return;
        } else {
            out.print(current.data + " ");
            preOrderWithRecursive(current.left);
            preOrderWithRecursive(current.right);
        }
    }

    /**
     * Pre-Order go through BST without Recursive.
     * Using stack to simulate recursive function calls.
     */
    public void preOrderWithoutRecursive() {
        if (root == null) {
            return;
        }

        // Root as the 1st node to be the stack top.
        Node current = root;
        GoodStack<Node> stack = new GoodStack<>(128);
        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.getTop();
            switch (current.state) {
                case NOOP: {
                    out.print(current.data + " ");
                    current.state = LEFT;
                    break;
                }
                case LEFT: {
                    if (current.left != null) {
                        stack.push(current.left);
                    }
                    current.state = RIGHT;
                    break;
                }
                case RIGHT: {
                    if (current.right != null) {
                        stack.push(current.right);
                    }
                    current.state = END;
                    break;
                }
                case END:
                default: {
                    current.state = NOOP;
                    stack.pop();
                }
            }
        }
    }

    /**
     * Mid-Order go through BST
     */
    public void midOrderWithRecursive() {
        midOrderWithRecursive(root);
    }

    public void midOrderWithRecursive(Node<T> current) {
        if (current == null) {
            return;
        } else {
            midOrderWithRecursive(current.left);
            out.print(current.data + " ");
            midOrderWithRecursive(current.right);
        }
    }

    /**
     * Post-Order go through BST
     */
    public void postOrderWithRecursive() {
        postOrderWithRecursive(root);
    }

    public void postOrderWithRecursive(Node<T> current) {
        if (current == null) {
            return;
        } else {
            postOrderWithRecursive(current.left);
            postOrderWithRecursive(current.right);
            out.println(current.data);
        }
    }

    /**
     * Go through BST by layer from top to bottom.
     */
    public void layerOrder() {

        if (root == null) {
            return;
        }

        // Root as the 1st node to be the queue head.
        Node current = root;
        Queue<Node> queue = new LinkedList();
        queue.offer(current);

        while (!queue.isEmpty()) {
            current = queue.peek();
            switch (current.state) {
                case NOOP: {
                    out.print(current.data + " ");
                    current.state = LEFT;
                    break;
                }
                case LEFT: {
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    current.state = RIGHT;
                    break;
                }
                case RIGHT: {
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                    current.state = END;
                    break;
                }
                case END:
                default: {
                    current.state = NOOP;
                    queue.poll();
                }
            }
        }

    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(0);

//        System.out.println(bst.contains(3));
        bst.preOrderWithRecursive();
        out.println();
        bst.preOrderWithoutRecursive();
        out.println();
        bst.layerOrder();


    }

}
