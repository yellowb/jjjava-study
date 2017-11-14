package week1.lesson1;


import org.apache.commons.lang3.ArrayUtils;

/**
 * 转换数字的进制
 */
public class RadixTransformer {

    /**
     * 把字符串形式的数字从一种进制转换成另一种进制
     * <p>
     * 假定只能支持2~10进制和正整数作为输入
     *
     * @param s
     * @param radixSrc
     * @param radixTgt
     * @return
     */
    public static String transform(String s, int radixSrc, int radixTgt) {
        int[] ints = splitToIntArr(s);
        int tenBased = transformToRadix10(ints, radixSrc);
        String target = transformToTargetRadix(tenBased, radixTgt);
        return target;
    }

    /**
     * 把输入字符串切成int数组, 字符串数字的高位在int数组的低位
     *
     * @param s
     * @return
     */
    public static int[] splitToIntArr(String s) {
        char[] chars = s.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; ++i) {
            ints[i] = (int) chars[i] - 48;   //  48即char '0'
        }
        return ints;
    }

    /**
     * 转换成10进制数
     *
     * @param digits
     * @param radixSrc
     * @return
     */
    public static int transformToRadix10(int[] digits, int radixSrc) {
        int result = 0;
        for (int i = digits.length - 1, j = 0; i >= 0; --i, ++j) {
            result += (digits[i] * Math.pow(radixSrc, j));
        }
        return result;
    }

    /**
     * 把10进制数转换成目标进制
     *
     * @param src      源10进制数
     * @param radixTgt 目标进制
     * @return char array 包含每一个位数字
     */
    public static String transformToTargetRadix(int src, int radixTgt) {

        char[] chars = new char[32];

        // Convert from Dec -> Target radix
        int remainder = src; // The remaining of input number.
        int index = 0;   // Position to write into chars.
        for (; remainder >= radixTgt; ++index, remainder /= radixTgt) {
            chars[index] = (char) ((remainder % radixTgt) + 48);
        }

        // The last char.
        if (remainder > 0) {
            chars[index] = (char) (remainder + 48);
        }

        ArrayUtils.reverse(chars);
        // 只取有效位
        return String.valueOf(chars, chars.length - index - 1, index + 1);
    }


    public static void main(String[] args) {
        String target = transform("11001", 2,3);
        System.out.println(target);
    }

}
