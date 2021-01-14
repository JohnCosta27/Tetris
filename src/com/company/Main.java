package com.company;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;


import javafx.scene.input.KeyCode;

public class Main extends Application  {

	static int[][] grid = new int[20][10];


    public void start(Stage primaryStage) {

        primaryStage.setTitle("Hello World");
        VBox root = new VBox();

        Label hello = new Label("Hello");
        Label world = new Label("World");
		root.getChildren().addAll(hello, world);
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(event ->  {
			if (event.getCode() == KeyCode.RIGHT) {
				System.out.println("Enter Pressed");
			}
		});
		primaryStage.setScene(scene);
        primaryStage.show();
        Game game = new  Game();
        game.start();

    }

    public static void main(String[] args) {
	//write your code here
        launch(args);

        //Game game = new Game();
        //game.start();

    }


}