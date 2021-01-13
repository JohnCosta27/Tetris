package com.company;

public enum Shape {

    L_SHAPE(new int[][] {{0, 0, 0}, {1, 1, 1}});
    private int[][] configure;

    private Shape(int[][] configure) {
        this.configure = configure;
    }

}
