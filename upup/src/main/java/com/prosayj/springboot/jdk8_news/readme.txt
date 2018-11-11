E:\书_001\书\JavaSE\写给大忙人看的Java SE 8.pdf


1. 接口的新特性
2. 注解的新特性
3. 集合的底层源码实现
4. 新日期时间的API
5. Optional类的使用
6. Lambda 表达式(Lambda Expressions)
7. Stream API


Java 9已于今年9月份发布，那么还有必要学习java 8 吗？

Java 8新特性简介:
Java 8 (又称为 jdk 1.8) 是 Java 语言开发的一个主要版本。
Java 8 是oracle公司于2014年3月发布，可以看成是自Java 5 以来最具革命性的版本。
Java 8为Java语言、编译器、类库、开发工具与JVM带来了大量新特性。

Java 8新特性简介:
代码更少(增加了新的语法：Lambda 表达式)
强大的 Stream API
速度更快
最大化减少空指针异常：Optional
Nashorn引擎，允许在JVM上运行JS应用
便于并行
注：
1.Nashorn，发音“nass-horn”,是德国二战时一个坦克的命名，同时也是java8新一代的javascript引擎。
2.javascript运行在jvm已经不是新鲜事了，Rhino早在jdk6的时候已经存在，但现在为何要替代Rhino，
官方的解释是Rhino相比其他javascript引擎（比如google的V8）实在太慢了，要改造Rhino还不如重写。所以Nashorn的性能也是其一个亮点。


并行流与串行流：
Java 8 中将并行进行了优化，我们可以很容易的对数据进行并行操作。Stream API 可以声明性地通过 parallel() 与 sequential() 在并行流与顺序流之间进行切换。

并行流就是把一个内容(数组或集合)分成多个数据块，并用不同的线程分别处理每个数据块的流。这样一来，你就可以自动把给定操作的工作负荷分配给多核处理器的所有内核，让他们都忙起来。整个过程无需程序员显示实现优化。






