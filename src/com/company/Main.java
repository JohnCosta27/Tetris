package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        launch(args);
    	
    	int[][] LShape = {{1, 0, 0},
    					  {1, 1, 1}};
    	
    	insertShape(LShape);
    	
    	printArray(grid);
    	
    }

    public static void printArray(int[][] grid) {
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			System.out.print(grid[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    public static void insertShape(int[][] shape) {
    	
    	int x = (grid[0].length - shape[0].length) / 2 + 1;
    	int y = 0;
    	
    	for (int i = 0; i < shape.length; i++) {
    		for (int j = 0; j < shape[0].length; j++) {
    			
    			grid[y + i][x + j] = shape[i][j];
    			
    		}
    	}
    	
    }
    
}