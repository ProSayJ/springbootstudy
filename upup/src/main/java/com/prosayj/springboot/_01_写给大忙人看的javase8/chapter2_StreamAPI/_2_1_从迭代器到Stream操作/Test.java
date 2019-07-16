package com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI._2_1_从迭代器到Stream操作;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        String contants = new String(Files.readAllBytes(Paths.get("alice.txer")), StandardCharsets.UTF_8);
        //将字符串分割为单词，非字母认为是分隔符
        List<String> words = Arrays.asList(contants.split("[\\P{L}]+"));


        //before
        int count = 0;
        for (String word : words) {
            if (word.length() > 12) {
                count++;
            }
        }
        //now 串行
        long count1 = words.stream().filter(word -> word.length() > 12).count();
        //now 并行
        long count2 = words.parallelStream().filter(word -> word.length() > 12).count();
    }
}
