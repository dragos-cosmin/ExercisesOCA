package org.example.inheritance;

public class TestCubeSquare {
    public static void main(String[] args) {
        Square shape=new Cube(2);
        System.out.println(shape.findSurfaceArea());
    }
}
