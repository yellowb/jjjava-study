package week5.lesson1;

/**
 * Tree node
 *
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<T> {

    public T data;

    public Node left;
    
    public Node right;

    public Node(T d) {
        this.data = d;
    }

    @Override
    public int compareTo(T o) {
        return this.compareTo(o);
    }
}
