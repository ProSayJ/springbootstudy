package com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI._2_3_filter_map和flatMap方法;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //注意：一个 Stream 只可以使用一次

        //1:这里，我们要将一个字符串流转换到另一个只包含长单词的流中 。
        List<String> worldList = new ArrayList<>(Arrays.asList("hello", "java8"));
        Stream<String> words = worldList.stream();
        words.filter(word -> word.length() > 12);

        //2:通过如下代码将所有单词转换为小写形式：
        words = worldList.stream();
        Stream<String> lowerCaseWords = words.map(String::toLowerCase);

        //3:该方法产生的流会包含每个单词的第一个字符 。
        words = worldList.stream();
        Stream<Character> firstChars = words.map(word -> word.charAt(0));


        //5.1:调用
        words = worldList.stream();
        Stream<Stream<Character>> result = words.map(word -> characterStream(word));


        //5.2:调用
        //你将会获得一个包含多个流的流 例如[... ['y','o','u','r'],['b','o','a','t']...]要将其展开为一个只包含字符串的流[... 'y','o','u','r','b','o','a','t'...],
        // 你需要使用 flatMap 方法，而不是 map方法：
        words = worldList.stream();
        Stream<Character> flatCharacterStream = words.flatMap(word -> characterStream(word));

        //对每个单词调用characterStream并展开结果
        Object[] objects = flatCharacterStream.toArray();
        for (Object object : objects) {
            if (object instanceof Character) {
                Character object1 = (Character) object;
                System.out.println(object1);
            }
        }
        System.out.println(objects.toString());
    }

    //4:现在，假设你有一个函数，它返回的不是一个值，而是一个包含多个值的流。
    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }
}
