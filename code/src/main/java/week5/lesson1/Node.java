package week5.lesson1;

/**
 * Tree node
 *
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<Node> {

    public T data;

    public Node left;

    public Node right;

    public Node(T d) {
        this.data = d;
    }

    @Override
    public int compareTo(Node o) {
        return this.data.compareTo((T) o.data);
    }
}
