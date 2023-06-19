package org.example.interfaceInheritance;

public interface B1 {
    default void doStuff(){
        System.out.println("B1.doStuff()");
    }
}
