# Problem.1 Java十进制转成二进制补码

1. 需要注意Integer.MIN_VALUE这个数

# Problem.2 Java不同进制互相转换
1. 暂时只想到先转成10进制, 再由10进制转换成目标进制的方法.

# Problem.3 数值类型的隐式转换
1. Byte.MAX_VALUE + 1 会隐式向上转型成int
2. 向上提升时会保持符号位
3. 向下转型时会丢失精度或符号位