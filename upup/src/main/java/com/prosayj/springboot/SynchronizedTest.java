package com.prosayj.springboot;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/11/6 上午 09:25
 * @since 1.0.0
 */
public class SynchronizedTest {
    public synchronized void method1() {
        System.out.println("Hello World!");
    }

    public void method2() {
        synchronized (this) {
            System.out.println("Hello World!");
        }
    }
}
/**
public class com.prosayj.springboot.SynchronizedTest {
public com.prosayj.springboot.SynchronizedTest();
        Code:
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: return

public synchronized void method1();
        Code:
        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #3                  // String Hello World!
        5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: return

public void method2();
        Code:
        0: aload_0
        1: dup
        2: astore_1
        3: monitorenter
        4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        7: ldc           #3                  // String Hello World!
        9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        12: aload_1
        13: monitorexit
        14: goto          22
        17: astore_2
        18: aload_1
        19: monitorexit
        20: aload_2
        21: athrow
        22: return
        Exception table:
        from    to  target type
        4    14    17   any
        17    20    17   any
}
 */
