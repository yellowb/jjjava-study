package week1.lesson3;

public class FuckFinal {

    public static void main(String args[]) {
        String a = "go die, ";
        final String b = "final";
        String c = "go die, " + b;
        String d = a + b;
        String e = "go die, final";
        System.out.println(e == c); //true，比较两个变量是否指向同一个对象
        System.out.println(e == d); //false
        System.out.println(c.equals(d));//true，比较两个字符串的值是否相同
    }
}
