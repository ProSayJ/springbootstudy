package com.prosayj.springboot.javase.gui;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/17 17:52
 * @since 1.0.0
 */
public class Demo01 {
    public static void main(String[] args) {
        //构造一个最初不可见的 Frame 新实例（）。
        Frame f = new Frame("test");
        //设置窗口大小,宽度500，高度400
        f.setSize(500, 400);
        //设置窗口位置为距离屏幕左边水平方向300，上方垂直方向200
        f.setLocation(300, 200);
        //设置窗体可见。
        f.setVisible(true);
        //设置窗体布局为流式布局。
        f.setLayout(new FlowLayout());

        //在窗体事件源上添加带有处理事件的监听器。
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //关闭窗口处理关闭动作监听事件
                System.exit(0);
            }
        });

        //在窗口中添加一个按钮；
        Button b = new Button("button");
        b.setSize(2000,2000);
        //将按钮添加到窗口内；
        f.add(b);
    }

}
