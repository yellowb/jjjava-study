package week1.lesson5;

/**
 * Created by HUANGYE2 on 11/16/2017.
 */
public class FuckBoxing {

    public static void main(String args[]) {
        Integer a = new Integer(1);
        Integer b = Integer.valueOf(1);
        Integer c = inc(0);
        Integer d = 1;

        System.out.println(a == b);  // false, a是新对象, b是缓存中的对象
        System.out.println(a.equals(b)); // true

        System.out.println(a == c); // false, a是新对象, c是缓存中的对象
        System.out.println(a.equals(c)); // true

        System.out.println(a == d);  // false, a是新对象, d是缓存中的对象
        System.out.println(a.equals(d)); // true

        System.out.println(b == c);  // true
        System.out.println(b.equals(c));  //true

        System.out.println(b == d);  // true
        System.out.println(b.equals(d)); // true

        System.out.println(((Long) 1L) == 1); // true, L24 左边先AutoBoxing变成对象, 再AutoUnBoxing变成long, 右边自动转型成long
        System.out.println(new Long(1).equals(1)); // false, 一个是new Long对象, 一个是Integer对象

        Long e = 100L;
        Long f = 100L;
        System.out.println(e == f);  // true, valueOf()从cache中取对象
        e = 1000L;
        f = 1000L;
        System.out.println(e == f);  // false, valueOf()超出cache范围, new对象

        // 练习
        System.out.println(((Long)1000L) == 1000);
        System.out.println(((Long)1000L) == Long.valueOf(1000));
        System.out.println(new Long(1).equals(1L));
    }

    public static Integer inc(Integer x) {
        return x + 1;
    }
}
