package org.example.designPatterns.factory;

/**
 * @author dragos.cosmin
 **/
public class TestCarFactory {
    public static void main(String[] args) {
        Car rover=CarFactory.getCar("Blue","6 Cylinders","SUV","RangeRover");
        Car royce=CarFactory.getCar("Green","8 Cylinders","Sedan","RollsRoyce");
        assert rover != null;
        System.out.println("Factory Car Type: "+rover.getClass().getSimpleName()+" "+rover);
        assert royce != null;
        System.out.println("Factory Car Type: "+royce.getClass().getSimpleName()+" "+royce);
    }
}
