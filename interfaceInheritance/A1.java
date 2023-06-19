package org.example.interfaceInheritance;

public interface A1 {
    default void doStuff(){
        System.out.println("A1.doStuff()");
    }
}
