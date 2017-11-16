# Problem.2 写一个Token解析器

需要一个状态机, 记住是单个字符的符号还是多个字符(数字), 这里是用buf来做的.

# Java.io包
1. 主要分为Stream和Reader/Writer, 前者操作的是字节, 后者是字符, 也意味着后者需要指定字符编码格式
2. 大部分类都遵循装饰者模式, 也就是说接口是一样的并且可以相互嵌套
3. 比较特殊的: StringXXXer(输入输出端为String), ByteArrayXXXStream(输入输出端为Array), ObjectXXXString(可以把一个Java对象写到某个流中或反过来读出)
