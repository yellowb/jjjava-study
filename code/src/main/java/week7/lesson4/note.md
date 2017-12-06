# HashMap源码解析

# 1. 查看 HashMap 里的 hash 方法，思考为什么不直接使用 key 的 hashCode，还要做一次转换呢?

参考：
1. [HashMap 源码解析](https://lfkdsk.github.io/2017/07/13/hashmap-source-code-read/)
2. [java中的HashMap中hash函数，只是单纯数学计算吗，还是这样设计目得又是为什么呢？](https://www.zhihu.com/question/62923854)