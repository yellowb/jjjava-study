# Java语言的品味（三）

## Default Methods
Java 8 引入了新的语言特性——默认方法（Default Methods）. Sample:
```java
interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
}

class ClassA implements InterfaceA {
}

public class Test {
    public static void main(String[] args) {
        new ClassA().foo(); // 打印：“InterfaceA foo”
    }
}
```
Why?

在 java 8 之前，接口与其实现类之间的 耦合度太高了，当需要为一个接口添加方法时，所有的实现类都必须随之修改。


