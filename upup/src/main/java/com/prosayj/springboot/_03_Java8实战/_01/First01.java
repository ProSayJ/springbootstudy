package com.prosayj.springboot._03_Java8实战._01;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class First01 {
    public static void main(String[] args) {
        //p1
        // jdk8之前
        List<Apple> inventory = new ArrayList<>();
        Collections.sort(inventory, new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        //jdk1.8
        inventory.sort(Comparator.comparing(Apple::getWeight));//本书中第一段Java 8的代码！

    }

    class Apple {
        private Integer weight;

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }
}
