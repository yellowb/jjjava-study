package week3.lesson1;

public class Main3 {
    public static void main(String args[]) {
        int n = 10;
        int t = fact(n);
        System.out.println(t);
    }

    public static int fact(int n){
        if (n == 0)
            return 1;
        else
            return n * fact(n - 1);
    }
}
