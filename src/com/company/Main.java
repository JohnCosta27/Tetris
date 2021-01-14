package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;


import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Main extends Application  {

	static int[][] grid = new int[20][10];


    public void start(Stage primaryStage) {

        Game game = new Game();

        primaryStage.setTitle("Hello World");
        VBox root = new VBox();

        Label hello = new Label("Hello");
        Label world = new Label("World");
		root.getChildren().addAll(hello, world);
		Scene scene = new Scene(root);

		scene.setOnKeyPressed(event ->  {
			if (event.getCode() == KeyCode.RIGHT) {
				game.rightClick();
			} else if (event.getCode() == KeyCode.LEFT) {
			    game.leftClick();
            }
		});

		primaryStage.setScene(scene);
        primaryStage.show();

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