package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._01_为什么要使用lambda表达式;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author yangjian
 * @description 按钮回调是一个会延时加载的例子。这里使用匿名内部类来实现。
 * @Date 上午 09:03 2019/9/10
 * @since 1.0.0
 */
public class _03_ButtonEvent extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World !");

        Button button = new Button();
        button.setText("hello");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Thinks for clickig!");
            }
        });


        StackPane root = new StackPane();
        root.getChildren().add(button);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
