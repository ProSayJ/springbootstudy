package com.prosayj.springboot.javafx_10_使用JavaFX场景图;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/21 15:29
 * @since 1.0.0
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class EmbeddedMediaPlayer extends Application {

    private static final String MEDIA_URL =
            "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Embedded Media Player");
        Group root = new Group();
        Scene scene = new Scene(root, 540, 210);

        // create media player
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();


        // create mediaView and add media player to the viewer
        MediaView mediaView = new MediaView(mediaPlayer);
        ((Group)scene.getRoot()).getChildren().add(mediaView);

    }
}
