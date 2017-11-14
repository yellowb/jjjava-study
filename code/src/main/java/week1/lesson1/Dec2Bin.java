package week1.lesson1;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class Dec2Bin {

    /**
     * Convert int to Binary String
     * Include positive & negative number
     *
     * @param number
     * @return
     */
    public static String dec2Bin(int number) {
        String bin = null;
        char[] chars = null;

        if (number == 0) {
            // When input is 0, then quickly return the 32-bin zero.
            return "00000000000000000000000000000000";
        }
        if (number == Integer.MIN_VALUE) {
            // When input is -2^31, then quickly return the value.
            return "10000000000000000000000000000000";
        }

        // -2^31+1 ~ 2^32-1
        if (number > 0) {
            // When input is positive, simply convert to 'sign-and-magnitude'.
            chars = positiveDec2Bin(number);
        } else if (number < 0) {
            // When input is negative, convert to 'two's complement'.
            chars = positiveDec2Bin(-number);
            invertBinChars(chars);
            addOneToBinChars(chars);
        }
        bin = String.valueOf(chars);
        return bin;
    }

    /**
     * Convert a positive number to binary form in char array.
     *
     * @param number
     * @return
     */
    public static char[] positiveDec2Bin(int number) {
        char[] binChars = new char[32];

        // Convert from Oct -> Bin
        int remainder = number; // The remaining of input number.
        int binIndex = 0;   // Position to write into binChars.
        for (; remainder >= 2; ++binIndex, remainder /= 2) {
            binChars[binIndex] = (char) ((remainder % 2) + 48);  // Store '1' if remainder is 1, '0' if 0. 48 is '0'.
        }

        // The last bin char.
        if (remainder > 0) {
            binChars[binIndex] = (char) (remainder + 48);
        }

        // Fill the un-touched positions
        Arrays.fill(binChars, ++binIndex, 32, '0');
        ArrayUtils.reverse(binChars);

        return binChars;
    }

    /**
     * Invert a binary char array ('1' -> '0' & '0' -> '1')
     *
     * @param chars
     */
    public static void invertBinChars(char[] chars) {
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '0') {
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
        }
    }

    /**
     * Add 1 to a binary char array.(Find the two's complement)
     *
     * @param chars
     */
    public static void addOneToBinChars(char[] chars) {
        int len = chars.length;
        for (int i = len - 1; i >= 0; --i) {
            if (chars[i] == '0') {
                chars[i] = '1';
                break;
            } else {
                chars[i] = '0';
            }
        }
    }

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
    }

}
