# Problem.1 Java十进制转成二进制补码
1. 基本思路就是用除法(%2)
2. 需要注意Integer.MIN_VALUE这个数

# Problem.2 Java不同进制互相转换
1. 暂时只想到先转成10进制, 再由10进制转换成目标进制的方法.

# Problem.3 数值类型的隐式转换
1. Byte.MAX_VALUE + 1 会隐式向上转型成int
2. 向上提升时会保持符号位
3. 向下转型时会丢失精度或符号位
4. byte -> short,char → int → long → float → double
5. boolean不能转换成数值

# Problem.4 浮点数在JVM中的存储形式
1. 没记错应该是IEEE754, 待查证

# ASCII码
1. 对26个英文字母来说, 同一个字母的小写字符要比大写字符的值大32, 
这样大小写转换时只需要做位操作, 把第5位变化即可, 因为位操作比加法操作快.
比如A=65, a=97.
