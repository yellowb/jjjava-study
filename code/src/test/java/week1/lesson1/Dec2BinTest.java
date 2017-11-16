package week1.lesson1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by HUANGYE2 on 11/14/2017.
 */
public class Dec2BinTest {

    @Test
    public void test_0() {
        int n = 0;
        assertEquals("Convert " + n + " to binary didn't match", pad(Integer.toBinaryString(n), 32, '0'), Dec2Bin.dec2Bin(n));
    }

    @Test
    public void test1() {
        int n = 1;
        assertEquals("Convert " + n + " to binary didn't match", pad(Integer.toBinaryString(n), 32, '0'), Dec2Bin.dec2Bin(n));
    }

    @Test
    public void test127() {
        int n = 127;
        assertEquals("Convert " + n + " to binary didn't match", pad(Integer.toBinaryString(n), 32, '0'), Dec2Bin.dec2Bin(n));
    }

    @Test
    public void test128() {
        int n = 128;
        assertEquals("Convert " + n + " to binary didn't match", pad(Integer.toBinaryString(n), 32, '0'), Dec2Bin.dec2Bin(n));
    }

    @Test
    public void testMaxInt() {
        int n = Integer.MAX_VALUE;
        assertEquals("Convert " + n + " to binary didn't match", pad(Integer.toBinaryString(n), 32, '0'), Dec2Bin.dec2Bin(n));
    }

    @Test
    public void testNe1() {
        int n = -1;
        assertEquals("Convert " + n + " to binary didn't match", Integer.toBinaryString(n), Dec2Bin.dec2Bin(n));
    }

    @Test
    public void testNe127() {
        int n = -127;
        assertEquals("Convert " + n + " to binary didn't match", Integer.toBinaryString(n), Dec2Bin.dec2Bin(n));
    }

    @Test
    public void testNe128() {
        int n = -128;
        assertEquals("Convert " + n + " to binary didn't match", Integer.toBinaryString(n), Dec2Bin.dec2Bin(n));
    }

    @Test
    public void testMinInt() {
        int n = Integer.MIN_VALUE;
        assertEquals("Convert " + n + " to binary didn't match", Integer.toBinaryString(n), Dec2Bin.dec2Bin(n));
    }

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


}
