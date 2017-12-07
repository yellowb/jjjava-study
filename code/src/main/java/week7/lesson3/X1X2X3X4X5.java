package week7.lesson3;

import java.util.HashMap;
import java.util.Map;

/**
 * For equation formula: a1x1^3 + a2x2^3 + a3x3^3 + a4x4^3 + a5x5^3 = 0.
 * And given a1,a2,a3,a4,a5, find out how many (x1,x2,x3,x4,x5) can fulfill the equation.
 * Assume -50 <= x1,x2,x3,x4,x5 <= 50
 */
public class X1X2X3X4X5 {

    public int findAnswer(int a1, int a2, int a3, int a4, int a5) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i4 = -50; i4 <= 50; i4++) {
            for(int i5 = -50; i5 <= 50; i5++) {
                //TODO
                // Calu and put into map
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        int a5 = 0;

        int amount = new X1X2X3X4X5().findAnswer(a1, a2, a3, a4, a5);
        System.out.println("There are " + amount + " answers.");
    }
}
