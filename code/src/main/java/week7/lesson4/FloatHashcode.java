package week7.lesson4;

import java.net.SocketPermission;

public class FloatHashcode {

    public static void main(String[] args) {
        Float f1 = 1.0f;
        Float f2 = 2.0f;
        Float f3 = 3.0f;
        Float f4 = 4.0f;
        Float f5 = 5.0f;
        Float f100 = 100.0f;

        /* The lower bits of their hashcode are 0 */

        /**
         * 111111100000000000000000000000
         * 1000000000000000000000000000000
         * 1000000010000000000000000000000
         * 1000000100000000000000000000000
         * 1000000101000000000000000000000
         * 1000010110010000000000000000000
         **/

        System.out.println(Integer.toBinaryString(f1.hashCode()));
        System.out.println(Integer.toBinaryString(f2.hashCode()));
        System.out.println(Integer.toBinaryString(f3.hashCode()));
        System.out.println(Integer.toBinaryString(f4.hashCode()));
        System.out.println(Integer.toBinaryString(f5.hashCode()));
        System.out.println(Integer.toBinaryString(f100.hashCode()));
    }

}
