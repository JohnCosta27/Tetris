package com.company;

import java.util.Scanner;

public class Game {

    private Shape currentShape;
    private int[][] grid = new int[20][10];

    public Game() {

        this.currentShape = new Shape();
        this.updateShape();
        this.printGrid();

    }

    public void start(){



        long start = System.currentTimeMillis();

        while (true) {

            long current = System.currentTimeMillis();

            //String input = keyboard.nextLine();
            //if (input.equals("left")) this.currentShape.left();
            //else if (input.equals("right")) this.currentShape.right();
            // else if (input.equals("down")) this.currentShape.down();

            //this.updateShape();
            //this.printGrid();

            if (current - start == 1000) {
                System.out.println("dsadsadsa");
                start = current;
            }

        }
    }

    public void printGrid() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                System.out.print(this.grid[i][j]);
            }
            System.out.println();
        }
    }

    public void updateShape() {

        this.grid = new int[20][10];

        int[][] configuration = this.currentShape.getConfiguration();

        int x = this.currentShape.getX();
        int y = this.currentShape.getY();

        for (int i = 0; i < configuration.length; i++) {
            for (int j = 0; j < configuration[0].length; j++) {

                if (configuration[i][j] == 1) grid[y + i][x + j] = configuration[i][j];

            }
        }

    }

    public void leftClick() {
        this.currentShape.left();
    }

    public void rightClick() {
        this.currentShape.right();
    }

}
