package com.company;

public enum Shape {

    L_SHAPE(new int[][] {{0, 0, 1}, {1, 1, 1}});
    private int[][] configuration;

    private Shape(int[][] configuration) {
        this.configuration = configuration;
    }

    public int[][] getConfiguration() {
        return configuration;
    }
}
