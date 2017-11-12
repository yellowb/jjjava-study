package week1.lesson1;

import java.util.Arrays;

public class Oct2Bin {

    /**
     * Convert int to Binary String
     * Include positive & negative number
     *
     * @param i
     * @return
     */
    public static String oct2Bin(int i) {
        //TODO
        return null;
    }

    public static String positiveOct2Bin(int i) {

        char[] chars = new char[32];

        // Make sure i is positive.
        for(int remain = i; remain >= 2;) {
            //TODO
        }


        return null;
    }

    // Seems no use!
    public static String pad(String origin, int len, char padChar) {
        int diff = len - origin.length();
        if (diff <= 0) {
            return origin;
        } else {
            char[] chars = new char[len];
            // Copy the original chars to the right side.
            System.arraycopy(origin.toCharArray(), 0, chars, diff, origin.length());
            // Fill the array with given char at the left side.
            Arrays.fill(chars, 0, diff, padChar);
            return String.valueOf(chars);
        }
    }

    public static void main(String[] args) {
        System.out.println(pad("1111", 3, '0'));
    }

}
