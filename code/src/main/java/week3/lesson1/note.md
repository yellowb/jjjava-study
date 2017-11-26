# Week3-1 深入理解函数调用（上）

# Java函数参数的传递方式
都是值传递(包括Reference, 也只是传了个Reference的Copy而已)

# 线程栈与栈帧
1. 一个线程有一个线程栈
2. 每次进入一个函数, 都会往线程栈中插入一个栈帧, 函数退出时则弹出这个栈帧
3. 每个栈帧 = 局部变量表 + 操作数栈 + 返回地址 + ...
4. 栈帧里的内容会在函数退出时被销毁, 这就是为什么说在函数里定义的Local变量不用担心多线程问题与垃圾回收问题的原因.

# Problem 1
以下代码
```java
    public static void swap(int a, int b){ 
        int t = a;
        a = b;
        b = t;
    }
```
实际上编译后变成如下字节码
```java
  // access flags 0x9
  public static swap(II)V
   L0
    LINENUMBER 11 L0
    ILOAD 0
    ISTORE 2
   L1
    LINENUMBER 12 L1
    ILOAD 1
    ISTORE 0
   L2
    LINENUMBER 13 L2
    ILOAD 2
    ISTORE 1
   L3
    LINENUMBER 14 L3
    RETURN
   L4
    LOCALVARIABLE a I L0 L4 0
    LOCALVARIABLE b I L0 L4 1
    LOCALVARIABLE t I L1 L4 2
    MAXSTACK = 1
    MAXLOCALS = 3
}
```
可见L1~L3只是对栈帧内的局部变量进行赋值而已, 所以改变不了外层函数里的变量.

# Problem 2
因为```fact(int n)```函数是递归调用的, 所以重点是其会生成11个栈帧(10~0), 越往后每个栈帧里的Local变量比前面那个小1.
当函数退出时, 把这个Local变量和上一个栈帧返回回来的那个数相乘, 再依次销毁, 向上回溯.