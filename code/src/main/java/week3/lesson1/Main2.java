package week3.lesson1;

public class Main2 {
    public static void main(String args[]) {
        int a = 1, b = 2;
        swap(a, b);
        System.out.println("a is " + a + ", b is " + b);
    }

    public static void swap(int a, int b){
        int t = a;
        a = b;
        b = t;
    }
}
