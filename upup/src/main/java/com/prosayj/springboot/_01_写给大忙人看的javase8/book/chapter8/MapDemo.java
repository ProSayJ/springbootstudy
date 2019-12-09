package com.prosayj.springboot._01_写给大忙人看的javase8.book.chapter8;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void demo1(){
		Map m = new HashMap();
		//putIfAbsent：往map里面放入值，如果key不存在，则插入，返回null；如果key存在，则返回对应的value
		System.out.println(m.putIfAbsent("s1", 123));
		System.out.println(m.putIfAbsent("s1", 1233));
	}

	public static void demo2(){
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("a1", 1);
		m.put("a2", 2);
		m.put("a3", 3);
		m.put("a4", 4);

		//computeIfAbsent：加入key不存在，则计算value，并插入map
		m.computeIfAbsent("a2", value -> value.hashCode() + 22);
		m.computeIfAbsent("a5", value -> value.hashCode() + 22);
		//computeIfPresent：加入的key存在时，则计算，并插入map
		m.computeIfPresent("a2", (key, oldValue) -> key.hashCode() + oldValue);
		//如果计算结果是null，则把原先的key删除
		m.computeIfPresent("a2", (key, oldValue) -> null);

		m.forEach((key, value) -> System.out.println(value));
	}

	public static void demo3(){
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("a1", 1);
		m.put("a2", 2);

		//merge：如果key不存在，则直接用value放入map
		m.merge("a3", 3, (oldValue, value) -> oldValue + value);
		//merge：如果key存在，则直接用oldValue、value计算，结果放入map
		m.merge("a2", 3, (oldValue, value) -> oldValue + value);
		//计算结果为null，则直接删除key
		m.merge("a1", 3, (oldValue, value) -> null);
		m.forEach((key, value) -> System.out.println(value));
	}

	public static void main(String[] args) {
		demo1();
		System.out.println("-------------");
		demo2();
		System.out.println("-------------");
		demo3();

		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("a1", 1);
		m.put("a2", 2);
		m.forEach((s, i) -> System.out.println(s + ": " + i));
	}

}
