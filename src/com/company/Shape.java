package com.company;

public class Shape {

    private int[][] configuration;
    private int x;
    private int y = 0;

    private int rotationStatus = 0;

    public Shape() {

        this.configuration = ShapeConfig.L_SHAPE.getConfiguration();
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

    public void down(){
        this.y++;
    }

    public void right(){
        if (this.x - rotationStatus < 10 - this.configuration.length - 1) this.x++;
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

        /*for (int i = 0; i < newConfig.length; i++) {
            for (int j = 0; j < newConfig[0].length; j++) {
                System.out.print(newConfig[i][j]);
            }
            System.out.println();
        }*/

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
