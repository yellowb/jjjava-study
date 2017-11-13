package week1.lesson1;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

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

    /**
     * Convert a positive number to binary form in char array.
     * @param number
     * @return
     */
    public static char[] positiveOct2Bin(int number) {
        char[] binChars = new char[32];

        // Convert from Oct -> Bin
        int remainder = number; // The remaining of input number.
        int binIndex = 0;   // Position to write into binChars.
        for (; remainder >= 2; ++binIndex, remainder /= 2) {
            binChars[binIndex] = (char) ((remainder % 2) + 48);  // Store '1' if remainder is 1, '0' if 0
        }

        // The last bin char.
        if(remainder > 0) {
            binChars[binIndex] = (char) (remainder + 48);
        }

        // Fill the un-touched positions
        Arrays.fill(binChars, ++binIndex, 32, '0');
        ArrayUtils.reverse(binChars);

        return binChars;
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

//        System.out.println(pad("1111", 7, '0'));

        int a = 14;

        System.out.println(positiveOct2Bin(a));

    }

}
