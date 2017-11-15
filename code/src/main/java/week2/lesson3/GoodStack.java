package week2.lesson3;

/**
 * 一个逻辑比教程中提供的更完善的Stack
 */
public class GoodStack<T> {

    private T[] data;
    private int size;
    private int top = 0; // 指向栈的顶部

    public GoodStack(int size) {
        this.size = size;
        this.data = new T[size];
    }

    public void push(int num) {
        checkUpperBound();
        data[top++] = num;
    }

    public int pop() {
        checkLowerBound();
        return data[--top];
    }

    public int getTop() {
        checkLowerBound();
        return data[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Clear and reset the top pointer to 0.
     */
    public void clear() {
        top = 0;
    }

    /**
     * Check the 'top' pointer is pointed within the valid range.
     * @throws ArrayIndexOutOfBoundsException
     */
    private void checkUpperBound() throws ArrayIndexOutOfBoundsException {
        if(this.top >= this.size) {
            throw new ArrayIndexOutOfBoundsException(this.top);
        }
    }

    /**
     * Check the 'top' pointer is pointed within the valid range.
     * @throws ArrayIndexOutOfBoundsException
     */
    private void checkLowerBound() throws ArrayIndexOutOfBoundsException {
        if(this.top <= 0) {
            throw new ArrayIndexOutOfBoundsException(this.top - 1);
        }
    }

    public static void main(String[] args) {
        GoodStack stack = new GoodStack(3);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
    }
}
