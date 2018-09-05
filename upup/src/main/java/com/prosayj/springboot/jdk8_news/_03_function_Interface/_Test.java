package com.prosayj.springboot.jdk8_news._03_function_Interface;

/**
 * @author yangjian
 * @description 函数式接口
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 15:52
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println("converted" + converted);
        /**
         * **************************上面的代码实例可以通过静态方法引用*******************************
         * java 8 允许你通过::关键字获取方法或者构造函数的的引用。上面的例子就演示了如何引用一个静态方法。
         * 而且，我们还可以对一个对象的方法进行引用：
         */
        Converter<String, Integer> converter2 = Integer::valueOf;
        Integer converted2 = converter.convert("123");
        System.out.println("converted2" + converted2);

        /**********************************************************************************************/
        Something something = new Something();
        Converter<String, String> converter3 = something::startsWith;
        String converted3 = converter3.convert("Java");
        System.out.println("converted3" + converted3);

        /**********************************************************************************************/
        /**
         * 我们通过Person::new来创建一个Person类构造函数的引用。Java编译器会自动地选择合适的构造函数来匹配PersonFactory.create函数的签名，并选择正确的构造函数形式。
         */
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

    }
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

class Person {
    String firstName;
    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("构造对象成功：" + firstName + "<==>" + lastName);
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
