package exampaper;

import java.util.Random;

/**
 *
 */

public class Test {

    public static void main(String[] args) {
        int a = 3;
        a += a -= a * a;
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(a);

        Random random = new Random();
        int r = random.nextInt(100);
        System.out.println(r);

        if (r < 30) {
            System.out.println(5);
        }
        else {
            int r2 = random.nextInt(9);
            if(r2 < 5) {
                System.out.println(r2);
            }
            else {
                System.out.println(r2 + 1);
            }
        }


    }
}
