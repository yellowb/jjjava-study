package week5.lesson1;

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
                    break;
                }
            } else {
                if (current.right != null)
                    current = current.right;
                else {
                    current.right = new Node(i);
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
            }
            else if(i.compareTo(current.data) < 0) {
                if(current.left != null) {
                    current = current.left;
                }
                else {
                    break;
                }
            }
            else {
                if(current.right != null) {
                    current = current.right;
                }
                else {
                    break;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(2);

        System.out.println(bst.contains(3));
    }

}
