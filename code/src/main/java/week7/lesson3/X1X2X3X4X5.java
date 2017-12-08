package week7.lesson3;

import java.util.HashMap;
import java.util.Map;

/**
 * For equation formula: a1x1^3 + a2x2^3 + a3x3^3 + a4x4^3 + a5x5^3 = 0.
 * And given a1,a2,a3,a4,a5, find out how many (x1,x2,x3,x4,x5) can fulfill the equation.
 * Assume -50 <= x1,x2,x3,x4,x5 <= 50
 */
public class X1X2X3X4X5 {

    public int findAnswerBad(int a1, int a2, int a3, int a4, int a5) {
        int amount = 0;

        for(int i1 = -50; i1 <= 50; i1++) {
            for (int i2 = -50; i2 <= 50; i2++) {
                for (int i3 = -50; i3 <= 50; i3++) {
                    for (int i4 = -50; i4 <= 50; i4++) {
                        for (int i5 = -50; i5 <= 50; i5++) {
                            int result = a1 * i1 * i1 * i1 + a2 * i2 * i2 * i2 + a3 * i3 * i3 * i3 + a4 * i4 * i4 * i4 + a5 * i5 * i5 * i5;
                            if(result == 0) {
                                amount++;
                            }
                        }
                    }
                }
            }
        }

        return amount;
    }

    public int findAnswerGood(int a1, int a2, int a3, int a4, int a5) {
        int amount = 0;
        Map<Integer, Pair> map = new HashMap<>();

        // a1x1^3 + a2x2^3 + a3x3^3 + a4x4^3 + a5x5^3 = 0
        // =>
        // a1x1^3 + a2x2^3 + a3x3^3 = -(a4x4^3 + a5x5^3)

        // 100 ^ 2 ops for x4 & x5
        for(int i4 = -50; i4 <= 50; i4++) {
            for(int i5 = -50; i5 <= 50; i5++) {
                // Calc and put into map
                int result = -(a4 * i4 * i4 * i4 + a5 * i5 * i5 * i5);
                if(!map.containsKey(result)) {
                    map.put(result, new Pair());
                }
                map.put(result, map.get(result).leftAddOne());
            }
        }

        // 100 ^ 3 ops for x1 & x2 & x3
        for(int i1 = -50; i1 <= 50; i1++) {
            for(int i2 = -50; i2 <= 50; i2++) {
                for(int i3 = -50; i3 <= 50; i3++) {
                    int result = a1 * i1 * i1 * i1 + a2 * i2 * i2 * i2 + a3 * i3 * i3 * i3;
                    Pair p;
                    if((p = map.get(result)) != null) {
                        p.rightAddOne();
                    }
                }
            }
        }


        for(Map.Entry<Integer, Pair> entry : map.entrySet()) {
            amount += entry.getValue().leftCount * entry.getValue().rightCount;
        }
        return amount;
    }

    static class Pair {
        public int leftCount = 0;
        public int rightCount = 0;

        public Pair leftAddOne() {
            this.leftCount++;
            return this;
        }

        public Pair rightAddOne() {
            this.rightCount++;
            return this;
        }
    }

    public static void main(String[] args) {
        int a1 = 1;
        int a2 = 2;
        int a3 = 3;
        int a4 = 4;
        int a5 = 5;

        long start = System.currentTimeMillis();
        int amount = new X1X2X3X4X5().findAnswerGood(a1, a2, a3, a4, a5);
        System.out.println("[Good]There are " + amount + " answers.[" + (System.currentTimeMillis() - start) + " ms]");
        start = System.currentTimeMillis();
        amount = new X1X2X3X4X5().findAnswerBad(a1, a2, a3, a4, a5);
        System.out.println("[Bad]There are " + amount + " answers.[" + (System.currentTimeMillis() - start) + " ms]");

        /***
         *
         * [Good]There are 17235 answers.[67 ms]
         * [Bad]There are 17235 answers.[47218 ms]
         *
         */
    }
}
