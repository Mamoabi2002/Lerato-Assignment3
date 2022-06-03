package com.example.gamee;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        stage.setTitle("moving clouds game!");
        BorderPane root=new BorderPane();
        Scene scene = new Scene(root,700,500);
        scene.getStylesheets().add("style.css");

        ImageView ima=createCloud1(scene);
        ImageView airplane=createAirplane(scene);
        ImageView cloud1=createCloud1(scene);
        ImageView cloud2 =createCloud2(scene);
        ImageView cloud3=createCloud3(scene);

        ImageView background=createAirplane(scene);
        root.getChildren().addAll(ima,cloud1,cloud2,cloud3,airplane,background);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = airplane.getX();
            double y = airplane.getY();

            switch (event.getCode()) {
                case LEFT -> airplane.setX(x -10);
                case RIGHT -> airplane.setX(x +10);
                case UP -> airplane.setY(y - 10);
                case DOWN -> airplane.setY(y + 10);

            }

            if (airplane.getBoundsInParent().intersects(cloud1.getBoundsInParent())
                    ||airplane.getBoundsInParent().intersects(cloud2.getBoundsInParent())
                    ||airplane.getBoundsInParent().intersects(cloud3.getBoundsInParent())){

                System.out.println("game over");

                scene.addEventFilter(KeyEvent.KEY_PRESSED, event1 -> {
                    double x1 = airplane.getX();
                    double y1 = airplane.getY();

                    switch (event.getCode()) {
                        case UP -> airplane.setY(y - 0);
                        case DOWN -> airplane.setY(y + 0);
                        case LEFT -> airplane.setX(y - 0);
                        case RIGHT -> airplane.setX(y + 0);

                    }
                });

            }
        });

        stage.setScene(scene);
        stage.show();
    }



    private ImageView createCloud1(Scene scene){
        ImageView cloud1 = new ImageView(new Image("cloud1.png"));
        cloud1.setFitWidth(150);
        cloud1.setFitHeight(150);
        cloud1.setY(150);
        cloud1.setX(1900);
        TranslateTransition c = new TranslateTransition(Duration.millis(13000),cloud1);
        c.setByX(-2000);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return cloud1;

    }
    private ImageView createCloud2(Scene scene){
        ImageView cloud2 = new ImageView(new Image("cloud2.png"));
        cloud2.setFitWidth(100);
        cloud2.setFitHeight(100);
        cloud2.setY(500);
        cloud2.setX(1800);
        TranslateTransition c = new TranslateTransition(Duration.millis(8800),cloud2);
        c.setByX(-2600);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return cloud2;
    }
    private ImageView createCloud3(Scene scene){
        ImageView cloud3 = new ImageView(new Image("cloud3.jpeg"));
        cloud3.setFitWidth(100);
        cloud3.setFitHeight(100);
        cloud3.setY(300);
        cloud3.setX(1800);
        TranslateTransition c = new TranslateTransition(Duration.millis(15000),cloud3);
        c.setByX(-2200);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return cloud3;
    }


    private ImageView createAirplane(Scene scene) {
        ImageView image = new ImageView(new Image("airplane.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());
        return image;
    }


    public static void main(String[] args) {
        launch();
    }
}