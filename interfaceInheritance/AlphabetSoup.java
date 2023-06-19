package org.example.interfaceInheritance;

public class AlphabetSoup implements A2,B1{
    @Override
    public void doStuff() {
        A2.super.doStuff();
    }
}
