package week3.lesson5;

public class ModAndBit {
    public static void main(String args[]) {

        long n = 100000 * 1000000L / 2;
        int a = 11;

        long start = System.currentTimeMillis();
        for(long i = 0; i < n; i++) {
            int r = a & 1;
        }
        long end = System.currentTimeMillis();

        System.out.println("Time for using & :" + (end - start) + " ms.");

        start = System.currentTimeMillis();
        for(long i = 0; i < n; i++) {
            int r = a % 2;
        }
        end = System.currentTimeMillis();

        System.out.println("Time for using & :" + (end - start) + " ms.");


    }

    public static void bitOp() {
        int i = 11;
        int r = i & 1;
    }

    public static void modOP() {
        int i = 11;
        int r = i % 2;
    }
}
