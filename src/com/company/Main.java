package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import javafx.scene.image.Image;

import java.io.File;


public class Main extends Application {

    private Canvas canvas = new Canvas();
    private Game game = new Game();
    private Timeline fiveSecondsWonder;

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Tetris");
        VBox root = new VBox();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        primaryStage.setWidth(Screen.getPrimary().getBounds().getWidth());
        primaryStage.setHeight(Screen.getPrimary().getBounds().getHeight());

        canvas.setWidth(primaryStage.getWidth());
        canvas.setHeight(primaryStage.getHeight());

        root.getChildren().add(canvas);

        draw();

        scene.setOnKeyPressed(e -> keyPressed(e));
        scene.setOnKeyReleased(e -> keyReleased(e));

        fiveSecondsWonder = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                gameLoop();
                            }
                        }));

        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();

    }

    private void gameLoop() {
        if (game.tick()) {

            // This is when the player loses.

            this.game = new Game();
            draw();

        } else {

            draw();

        }
    }

    private void keyReleased(KeyEvent e) {

        KeyCode key = e.getCode();
        if (key == KeyCode.DOWN) {
            System.out.println(fiveSecondsWonder.getRate());
            fiveSecondsWonder.setRate(1);
            System.out.println(fiveSecondsWonder.getRate());
            draw();
        }

    }

    private void keyPressed(KeyEvent e) {

        // TODO : TURN INTO SWITCH CASE

        KeyCode key = e.getCode();

        if (key == KeyCode.LEFT) {  // left arrow key
            game.leftClick();
            draw();
        } else if (key == KeyCode.RIGHT) {
            game.rightClick();
            draw();
        } else if (key == KeyCode.DOWN) {

            fiveSecondsWonder.setRate(15);
            draw();

        } else if (key == KeyCode.UP) {

            game.upClick();
            draw();

        }

        //fiveSecondsWonder.setRate(0);


    }

    private void draw() {

        GraphicsContext context = canvas.getGraphicsContext2D();
        Image image = new Image(new File("pixelgrid.png").toURI().toString());

        /*
        The drawing of the image can probably be optimised.
         */

        double height = canvas.getHeight();
        double width = canvas.getWidth();
        double squareSize = height / 20;

        context.drawImage(image, (width / 2) - (squareSize * 5), 0, squareSize * 10, height);

        int[][] grid = game.getGrid();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                context.setFill(this.game.getColor());
                if (grid[i][j] == 1 || grid[i][j] == 2) context.fillRect((width / 2) - (squareSize * 5) + j * squareSize, i * squareSize, squareSize - 2, squareSize - 2);

            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}