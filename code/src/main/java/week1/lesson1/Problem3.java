package week1.lesson1;

public class Problem3 {

    public static void main(String[] args) {
        short a = Byte.MIN_VALUE;
        int b = Short.MIN_VALUE;
        short c = Byte.MAX_VALUE + 1;
        byte d = (byte)(Byte.MAX_VALUE + 1);    // -128, (Byte.MAX_VALUE + 1)会向上转型成int, 再强制转换成byte截断
        int e = (Byte.MAX_VALUE + 1);   // 128
        byte f = (byte)Short.MIN_VALUE; // 0, 向下转换被截断丢掉了精度

        System.out.println("ok");
    }

}
