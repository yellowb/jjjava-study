package week6.lesson2;

/**
 * AVL Tree
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> {

    private AVLNode<T> root;

    public void insert(T i) {
        if(root == null) {
            root = new AVLNode<>(i);
            return;
        }

        insert(root, i);
    }

    public void insert(AVLNode<T> root, T i) {

    }

}
