package com.company;

import javafx.scene.paint.Color;

public enum ShapeConfig {

    T_SHAPE(new int[][] {{0, 1, 0}, {1, 1, 1}}, Color.web("710193")),
    J_SHAPE(new int[][] {{1, 0, 0}, {1, 1, 1}}, Color.web("1338BE")),
    L_SHAPE(new int[][] {{0, 0, 1}, {1, 1, 1}}, Color.web("E1AD01")),
    CUBE_SHAPE(new int[][] {{1, 1}, {1, 1}}, Color.web("FFF200")),
    LINE_SHAPE(new int[][] {{1, 1, 1, 1}}, Color.web("26F7FD")),
    S_SHAPE(new int[][] {{0, 1, 1}, {1, 1, 0}}, Color.web("C0FF02")),
    Z_SHAPE(new int[][] {{1, 1, 0}, {0, 1, 1}}, Color.web("FF0000"));

    private int[][] configuration;
    private Color color;

    private ShapeConfig(int[][] configuration, Color color) {
        this.configuration = configuration;
        this.color = color;
    }

    public int[][] getConfiguration() {
        return this.configuration;
    }

    public Color getColor() {
        return this.color;
    }

}
