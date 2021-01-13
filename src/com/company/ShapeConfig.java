package com.company;

public enum ShapeConfig {

    L_SHAPE(new int[][] {{0, 0, 1}, {1, 1, 1}});

    private int[][] configuration;

    private ShapeConfig(int[][] configuration) {
        this.configuration = configuration;
    }

    public int[][] getConfiguration() {
        return this.configuration;
    }

}
