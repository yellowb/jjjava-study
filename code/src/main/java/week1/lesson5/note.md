# Java语言的品味(二)
1. 掌握Java中的值类型和引用类型
2. 掌握Java中的字面量。了解其他现代语言的字面量。
3. 掌握值Java中的自动拆装箱

# 自动拆装箱的本质
自动拆装箱实际上是Java提供的语法糖.
1. 结合Bytecode来看, AutoBoxing是编译器会自动生成调用valueOf()的代码。
2. AutoUnBoxing则是编译器自动生成调用xxxValue()的代码(比如Integer.intValue())

# 注意包装类的cache
valueOf函数会在一定范围内从cache中取对象



