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

    public void tick() {

        currentShape.down();
        updateShape();
        printGrid();

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
        printGrid();
    }

    public void rightClick() {
        this.currentShape.right();
        printGrid();
    }

    public int[][] getGrid() {
        return this.grid;
    }

}
