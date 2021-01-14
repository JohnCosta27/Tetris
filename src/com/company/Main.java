package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;


public class Main extends Application {

	static int[][] grid = new int[20][10];


    public void start(Stage primaryStage) {

        primaryStage.setTitle("Hello World");
        VBox root = new VBox();
        primaryStage.setScene(new Scene(root));
        Label hello = new Label("Hello");
        Label world = new Label("World");
        root.getChildren().addAll(hello, world);
        primaryStage.show();

    }

    public static void main(String[] args) {
	//write your code here
        // launch(args);

        Game game = new Game();

    }

}