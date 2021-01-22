package com.company;

import javafx.scene.paint.Color;

public class Game {

    private Shape currentShape;
    private int[][] grid = new int[20][10];

    public Game() {

        this.currentShape = new Shape();
        this.updateShape();
        this.printGrid();

    }

    public boolean tick() {

        if (currentShape.getY() + currentShape.getConfiguration().length == 20 || collision(0, 1)) {
            setShape();
            checkRows();
            this.currentShape = new Shape();
            if (currentShape.getY() + currentShape.getConfiguration().length == 20 || collision(0, 1)) {
                return true;
            }
        } else {
            currentShape.down();
        }

        updateShape();
        return false;
    }

    public void printGrid() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                System.out.print(this.grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    public void updateShape() {

        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                if (grid[i][j] == 1) grid[i][j] = 0;
            }
        }

        int[][] configuration = this.currentShape.getConfiguration();

        int x = this.currentShape.getX();
        int y = this.currentShape.getY();

        for (int i = 0; i < configuration.length; i++) {
            for (int j = 0; j < configuration[0].length; j++) {

                if (configuration[i][j] == 1) {
                    grid[y + i][x + j] = configuration[i][j];
                }

            }
        }

    }

    public void setShape() {

        int[][] configuration = this.currentShape.getConfiguration();

        int x = this.currentShape.getX();
        int y = this.currentShape.getY();

        for (int i = 0; i < configuration.length; i++) {
            for (int j = 0; j < configuration[0].length; j++) {

                if (configuration[i][j] == 1) grid[y + i][x + j] = 2;

            }
        }

    }

    public boolean collision(int dx, int dy) {

        int[][] configuration = this.currentShape.getConfiguration();

        int x = this.currentShape.getX() + dx;
        int y = this.currentShape.getY() + dy;

        for (int i = 0; i < configuration.length; i++) {
            for (int j = 0; j < configuration[0].length; j++) {

                    if (configuration[i][j] == 1 && grid[i + y][j + x] == 2) return true;

            }
        }

        return false;

    }

    public void leftClick() {
        if (!collision(-1, 0)) {
            this.currentShape.left();
            this.updateShape();
        }
    }

    public void rightClick() {
        if (!collision(1, 0)) {
            this.currentShape.right();
            this.updateShape();
        }
    }

    public void upClick() {
        this.currentShape.rotateLeft();
        this.currentShape.rotateLeft();
        this.currentShape.rotateLeft();
        this.updateShape();
    }

    public void checkRows() {

        for (int i = this.grid.length - 1;0 <= i  ; i--) {

            boolean clear = true;

            for (int j = 0; j < this.grid[0].length; j++) {
                if (this.grid[i][j] == 0) {
                    clear = false;
                    break;
                }
            }

            if (clear) {
                for (int j = 0; j < this.grid[0].length; j++) {
                    this.grid[i][j] = 0;
                }
                for (int j = i; j > 0; j--) {
                    grid [j] = grid[j-1];
                }
                grid[0] = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                i --;
            }

        }

    }

    public int[][] getGrid() {
        return this.grid;
    }

    public Color getColor() {
        return this.currentShape.getColor();
    }

}
