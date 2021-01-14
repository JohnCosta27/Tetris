package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Main extends Application {

    public void start(Stage primaryStage) {

        Game game = new Game();

        primaryStage.setTitle("Hello World");
        VBox root = new VBox();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                game.rightClick();
            } else if (event.getCode() == KeyCode.LEFT) {
                game.leftClick();
            }
        });

        primaryStage.show();

        Canvas canvas = new Canvas(primaryStage.getWidth(), primaryStage.getHeight());
        GraphicsContext context = canvas.getGraphicsContext2D();

        double height = primaryStage.getHeight();
        double width = primaryStage.getWidth();
        double squareSize = height / 20;

        context.setFill(Color.BLACK);
        context.fillRect((width / 2) - (squareSize * 5), 0, squareSize * 10, height);

        context.setStroke(new Color(0.1, 0.1, 0.1, 1));
        context.setLineWidth(1);

        for (int i = 1; i < 20; i++) {
            context.moveTo((width / 2) - (squareSize * 5), i * squareSize);
            context.lineTo((width / 2) + (squareSize * 5), i * squareSize);
            context.stroke();
            for (int j = 1; j < 10; j++) {
                final double v = (width / 2) - (squareSize * 5) + j * squareSize;
                context.moveTo(v, 0);
                context.lineTo(v, height);
                context.stroke();
            }
        }

        root.getChildren().add(canvas);

        Timeline fiveSecondsWonder = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                game.tick();
                            }
                        }));

        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();

    }


    public static void main(String[] args) {
        //write your code here
        launch(args);

        //Game game = new Game();
        //game.start();

    }


}