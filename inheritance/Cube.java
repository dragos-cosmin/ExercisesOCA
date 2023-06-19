package org.example.inheritance;

public class Cube extends Square{

    public Cube(double length) {
        super(length);
    }

    @Override
    public double findSurfaceArea() {
        return super.findSurfaceArea()*6;
    }
}
