package org.example;

public class StandardMethods {
    public static void printPerimeter(double...sides){
        double result=0;
        for (double side :
                sides) {
            result+=side;
        }
        System.out.println("Perimeter is "+result);
    }

    public static void main(String[] args) {
        StandardMethods.printPerimeter();
        StandardMethods.printPerimeter(2.20,5.23,11);
        StandardMethods.printPerimeter(5,25,20);
    }
}
