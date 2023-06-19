package org.example.interfaceInheritance;

public interface Black {
    default void getColor(){
        System.out.println("Black");
    }
}
