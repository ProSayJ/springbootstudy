package com.prosayj.springboot.jdk8_news.book.chapter3.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import jdk8_news.book.domain.Person;
import jdk8_news.book.service.PersonService;


public class Lambda {

	/**
	 * 所有lambda表达式都是延迟执行的，如果你希望一段代码立刻执行，就没有必要使用lambda表达式了。
	 * 下面的例子：
	 * logger.info("x: " + x);
	 * 如果日志级别设置为忽略info消息时，改字符串会被计算并传递给info方法，然后再确定是否真的要执行。为什么不在确定需要打印时，再将字符串合并呢。
	 * 下面的方法提供了延迟记录日志的能力
	 * */
	public void info(Logger logger, Supplier<String> message){
		if(logger.isLoggable(Level.INFO)){
			logger.info(message.get());
		}
	}

	//接收lambda表达式作为参数
	public static void addSalary(Person p, BiConsumer<PersonService, Person> f){
		f.accept(new PersonService(), p);
		System.err.println(p);
	}

	//返回lambda表达式
	public static void initPerson(Supplier<Person> s){
		System.out.println(s.get());
	}

	//组合
	public static void compose(Person person){
		PersonService ps = new PersonService();
		UnaryOperator<Person> fu = p -> ps.addSalary2(p);
		UnaryOperator<Person> fu2 = p -> ps.reduceSalary2(p);
		ps.compose(person, fu2, fu);
		System.out.println(person);
	}

	public static void main(String[] args) {
		Lambda l = new Lambda();
		Logger logger = Logger.getLogger("com.chapter3.lambda.Lambda");
		String x = "abc";
		l.info(logger, () -> "x: " + x);

		Person person = new Person("男", "张苏磊", 34, 30000);
		BiConsumer<PersonService, Person> f = (ps, p) -> ps.addSalary(p);
		addSalary(person, f);

		PersonService ps = new PersonService();
		Supplier<Person> f2 = ps.getPerson("男", "张苏磊", 34, 50000);
		initPerson(f2);

		compose(person);
	}

}
