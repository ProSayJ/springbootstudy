package com.prosayj.springboot._01_写给大忙人看的javase8.book.methodquote;

/**方法引用的形式：相当于把lambda表达式的代码抽取到一个方法里。
 * 1、静态方法(ClassName::methodName)
 * 2、对象的实例方法(instanceRef::methodName)
 * 3、对象的super方法(super::methodName)
 * 4、类型的实例方法(ClassName::methodName)，引用时可静态方法时一样的，但是这里的methodName是一个实例方法
 * 5、类的构造方法(ClassName::new)
 * 6、数组的构造方法(TypeName[]::new)
 * @author DELL
 *
 */
public class Demo {

	private String name;

	public Demo(String name){
		this.name = name;
		System.out.println("构造方法" + name);
	}

	public Demo(){
	}

	public static void main(String[] args) {
		myPrint(s -> s + " Demo", "lambda表达式"); // 传统的使用lambda表达式

		Interface1 inter = Demo::hello;
		myPrint(inter, "静态方法引用"); // 静态方法引用：只要参数和返回值一致就行

		Interface2 inter2 = Demo::hello2;
		System.out.println(inter2.mPrint(new Demo(), "普通方法引用"));

		//构造方法引用，new相当于返回当前类型的实例方法
		Interface3 inter3 = Demo::new;
		inter3.mPrint("张三");
	}

	public static String hello(String s){
		return s + " Demo";
	}

	/**普通方法的引用，在调用的时候，功能接口中的唯一方法的第一个参数作为该引用方法的接收者，其余参数依次作为引用方法的参数。
	 * 接收者：负责具体实施和执行一个请求，任何一个类都可以作为接收者，实施和执行请求的方法叫做行动方法。
	 * @param s
	 * @return
	 */
	public String hello2(String s){
		return s + " Demo";
	}

	public static void  myPrint(Interface1 inter, String s){
		String str = inter.mPrint(s);
		System.out.println(str);
	}

}
