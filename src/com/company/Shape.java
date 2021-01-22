package com.company;

import javafx.scene.paint.Color;

import java.util.Random;

public class Shape {

    private int[][] configuration;
    private int x;
    private int y = 0;
    private Color color;

    private int rotationStatus = 0;

    public Shape() {

        Random ran = new Random();
        int nextShape = ran.nextInt(ShapeConfig.values().length);

        this.configuration = ShapeConfig.values()[nextShape].getConfiguration();
        this.color = ShapeConfig.values()[nextShape].getColor();

        this.x = (10 - this.configuration[0].length) / 2 + 1;

    }

    public int[][] getConfiguration() {
        return this.configuration;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Color getColor() {
        return this.color;
    }

    public void down(){
        this.y++;
    }

    public void right(){
        if (this.x - rotationStatus < 10 - this.configuration.length) this.x++;
    }

    public void left(){
        if (this.x + rotationStatus > 0) this.x--;
    }

    public void rotateLeft() {

        int[][] newConfig = new int[this.configuration[0].length][this.configuration.length];

        for (int i = 0; i < this.configuration.length; i++) {
            for (int j = 0; j < this.configuration[0].length; j++) {
                newConfig[j][i] = this.configuration[i][this.configuration[0].length - j - 1];
            }
        }

        this.configuration = newConfig;

        if (this.rotationStatus == 0) {
            this.rotationStatus = this.configuration.length;
        } else {
            this.rotationStatus = 0;
        }

        if (this.x + this.configuration[0].length >= 10) {
            this.x = 10 - this.configuration[0].length;
        } else if (this.x < 0) {
            this.x = 0;
        }

        if (this.y + this.configuration.length >= 20) {
            this. y = 20 - this.configuration.length;
        }

    }

}
