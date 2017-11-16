package week1.lesson5;

/**
 * Answer to Problem.3: Let <code>new MyLong(1).equals(1)<code/> return true
 */
public class MyLong {

    private final long value;

    public MyLong(long value) {
        this.value = value;
    }

    /**
     * New implementation to let <code>new MyLong(1).equals(1)<code/> return true
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        // Change 'Long' -> 'Number' is enough.
        if (obj instanceof Number) {
            return value == ((Number)obj).longValue();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new MyLong(1).equals(1));
    }
}
