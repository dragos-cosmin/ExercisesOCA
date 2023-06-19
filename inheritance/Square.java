package org.example.inheritance;

public class Square {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double findSurfaceArea(){
        return length*length;
    }
}
