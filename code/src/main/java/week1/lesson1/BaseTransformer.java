package week1.lesson1;


public class BaseTransformer {

    /**
     * 把字符串形式的数字从一种进制转换成另一种进制
     *
     * 假定只能支持2~10进制
     *
     * @param s
     * @param radixSrc
     * @param radixTgt
     * @return
     */
    public static String transform(String s, int radixSrc, int radixTgt) {

        //TODO



        return null;
    }

    /**
     * 把输入字符串切成int数组, 字符串数字的高位在int数组的低位
     * @param s
     * @return
     */
    public static int[] splitToIntArr(String s) {
        char[] chars = s.toCharArray();
        int[] ints = new int[chars.length];
        for(int i = 0; i < chars.length; ++i) {
            ints[i] = (int)chars[i] - 48;   //  48即char '0'
        }
        return ints;
    }

    /**
     * 转换成10进制数
     * @param digits
     * @param radixSrc
     * @return
     */
    public static int transformToBase10(int[] digits, int radixSrc) {
        int result = 0;
        for(int i = digits.length - 1, j = 0; i >= 0; --i, ++j) {
            result += (digits[i] * Math.pow(radixSrc, j));
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = splitToIntArr("1111");

        int tenBased = transformToBase10(ints, 2);

        System.out.println(tenBased);
    }

}
