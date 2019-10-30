package com.prosayj.springboot.zljdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/19 下午 11:45
 * @since 1.0.0
 */
public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My JFrame");
        JButton jBtton = new JButton("My JBtton");
        jBtton.addActionListener(e -> System.out.println("Button Pressend"));

        jFrame.add(jBtton);
        //组件大小
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
