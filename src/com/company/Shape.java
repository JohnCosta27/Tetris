package com.company;

public enum Shape {

    L_SHAPE(new int[][] {{0, 0, 1}, {1, 1, 1}});
    private int[][] configuration;
    private int x= 0;
    private int y = 0;

    private Shape(int[][] configuration) {
        this.configuration = configuration;
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
}
