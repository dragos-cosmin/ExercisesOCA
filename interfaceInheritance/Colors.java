package org.example.interfaceInheritance;

public class Colors implements Black, Red, Gold{
    public static void main(String[] args) {
        Colors colors=new Colors();
        colors.getColor();
    }
}
