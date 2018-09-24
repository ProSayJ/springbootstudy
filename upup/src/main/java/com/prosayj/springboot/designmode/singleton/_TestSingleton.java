package com.prosayj.springboot.designmode.singleton;


public class _TestSingleton {
    public static void main(String[] args) {
		/*
		Singleton_01 instance_01 = Singleton_01.getInstance_01();
		Singleton_01 instance_02 = Singleton_01.getInstance_01();
		System.out.println(instance_01 == instance_02);
		*/
		
		
		/*		
		Singleton_02 instance_01 = Singleton_02.getInstance_02();
		Singleton_02 instance_02 = Singleton_02.getInstance_02();
		System.out.println(instance_01 == instance_02);
		 */		
		
		
		/*
		Singleton_03 instance_01 = Singleton_03.getInstance_03();
		Singleton_03 instance_02 = Singleton_03.getInstance_03();
		System.out.println(instance_01 == instance_02);
		*/
		
		/*
		Singleton_04 instance_01 = Singleton_04.getInstance_04();
		Singleton_04 instance_02 = Singleton_04.getInstance_04();
		System.out.println(instance_01 == instance_02);
		*/
		
		/*
		Singleton_05 instance_01 = Singleton_05.getInstance_05();
		Singleton_05 instance_02 = Singleton_05.getInstance_05();
		System.out.println(instance_01 == instance_02);
		*/


        Singleton_06 instance_01 = Singleton_06.getInstance_06();
        Singleton_06 instance_02 = Singleton_06.getInstance_06();
        System.out.println(instance_01 == instance_02);
		
		
		/*
		Singleton_07 instance_01 = Singleton_07.getSingleton_07();
		Singleton_07 instance_02 = Singleton_07.getSingleton_07();
		System.out.println(instance_01 == instance_02);
		*/
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}

/**
 * 第一种（懒汉，线程不安全）：这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。
 */
class Singleton_01 {
    private Singleton_01() {
    }

    private static Singleton_01 singleton_01;

    public static Singleton_01 getInstance_01() {
        if (singleton_01 != null) {
            return new Singleton_01();
        } else {
            return singleton_01;
        }
    }
}


/**
 * 第二种（懒汉，线程安全）：这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，
 * 但是，遗憾的是，效率很低，99%情况下不需要同步。
 */
class Singleton_02 {
    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance_02() {
        if (instance == null) {
            instance = new Singleton_02();
        }
        return instance;
    }
}

/**
 * 第三种（饿汉）：
 * 这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，虽然导致类装载的原因有很多种，
 * 在单例模式中大多数都是调用getInstance方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
 * 这时候初始化instance显然没有达到lazy loading的效果。
 */
class Singleton_03 {
    private static Singleton_03 instance_03 = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance_03() {
        return instance_03;
    }
}


/**
 * 第四种（饿汉，变种）：表面上看起来差别挺大，其实更第三种方式差不多，都是在类初始化即实例化instance
 */
class Singleton_04 {
    private static Singleton_04 instance_04 = null;

    static {
        instance_04 = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 getInstance_04() {
        return instance_04;
    }
}


/**
 * 第五种（静态内部类）：
 * 多线程并发情况下最提倡的一种写法，也是最安全的一种写法。
 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，它跟第三种和第四种方式不同的是（很细微的差别）：
 * 第三种和第四种方式是只要Singleton类被装载了，那么instance就会被实例化（没有达到lazy loading效果），
 * 而这种方式是Singleton类被装载了，instance不一定被初始化。因为SingletonHolder类没有被主动使用，
 * 只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance。
 * 想象一下，如果实例化instance很消耗资源，我想让他延迟加载，另外一方面，我不希望在Singleton类加载时就实例化，
 * 因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化instance显然是不合适的。
 * 这个时候，这种方式相比第三和第四种方式就显得很合理。
 */
class Singleton_05 {
    private static class SingletonHolder {
        private static final Singleton_05 INSTANCE = new Singleton_05();
    }

    private Singleton_05() {
    }

    public static final Singleton_05 getInstance_05() {
        return SingletonHolder.INSTANCE;
    }
}


/**
 * 第六种（枚举）：
 * 这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，
 * 可谓是很坚强的壁垒啊，不过，个人认为由于1.5中才加入enum特性，用这种方式写不免让人感觉生疏，在实际工作中，我也很少看见有人这么写过。
 */
class Singleton_06 {
    private Singleton_06() {
    }

    public static Singleton_06 getInstance_06() {
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;
        private Singleton_06 singleton;

        //JVM会保证此方法绝对只调用一次
        private Singleton() {
            singleton = new Singleton_06();
        }

        public Singleton_06 getInstance() {
            return singleton;
        }
    }
}


/**
 * 第七种（双重校验锁）：//dubbo cheack 也是最提倡的一种多线程单例的写法
 * 这个是第二种方式的升级版，俗称双重检查锁定，详细介绍请查看：http://www.ibm.com/developerworks/cn/java/j-dcl.html
 */
class Singleton_07 {
    private volatile static Singleton_07 singleton_07;

    private Singleton_07() {
    }

    public static Singleton_07 getSingleton_07() {
        if (singleton_07 == null) {
            synchronized (Singleton_07.class) {
                if (singleton_07 == null) {
                    singleton_07 = new Singleton_07();
                }
            }
        }
        return singleton_07;
    }


    /*
    总结
    有两个问题需要注意：
    1、如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假定不是远端存取，例如一些servlet容器对每个servlet使用完全不同的类  装载器，这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。
    2、如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。
    */

    /**
     * 对第一个问题修复的办法是：
     */
    private static Class getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        if (classLoader == null) {
            classLoader = Singleton_07.class.getClassLoader();
        }
        return (classLoader.loadClass(classname));
    }
}


/**
 * 对第二个问题修复的办法是：
 */
class Singleton_08 implements java.io.Serializable {
    public static Singleton_08 INSTANCE = new Singleton_08();

    protected Singleton_08() {

    }

    private Object readResolve() {
        return INSTANCE;
    }
}   

/*
对我来说，我比较喜欢第三种和第五种方式，简单易懂，而且在JVM层实现了线程安全（如果不是多个类加载器环境），一般的情况下，我会使用第三种方式，只有在要明确实现lazy loading效果时才会使用第五种方式，另外，如果涉及到反序列化创建对象时我会试着使用枚举的方式来实现单例，不过，我一直会保证我的程序是线程安全的，而且我永远不会使用第一种和第二种方式，如果有其他特殊的需求，我可能会使用第七种方式，毕竟，JDK1.5已经没有双重检查锁定的问题了。
不过一般来说，第一种不算单例，第四种和第三种就是一种，如果算的话，第五种也可以分开写了。所以说，一般单例都是五种写法。懒汉，恶汉，双重校验锁，枚举和静态内部类。
我很高兴有这样的读者，一起共勉。
*/
