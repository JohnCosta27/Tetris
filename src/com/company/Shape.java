package com.company;

public class Shape {

    private int[][] configuration;
    private int x= 0;
    private int y = 0;

    public Shape(int[][] configuration) {
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

    public void down(){
        this.y++;
    }

    public void right(){
        if ( this.x < 10-this.configuration.length) this.x++;
    }

    public void left(){
        if ( this.x!=0)this.x--;
    }






}
