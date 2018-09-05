package com.prosayj.springboot.jdk8_news.book;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    //如何返回集合中第一个匹配的元素
    public Integer findFirstMatch() {
        return Stream.of(1, 4, 2, 5, 6, 3)
                .filter(i -> i > 3)
                .findFirst()
                .orElse(null);
    }

    //翻页效果
    public List<Integer> page() {
        return Stream.of(1, 4, 2, 5, 6, 3).skip(3).limit(5).collect(Collectors.toList());
    }

}
