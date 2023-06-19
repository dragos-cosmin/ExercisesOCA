package org.example.annotations;

public interface Pet {
    public abstract int breed();

    public default Pet callPet(){
        return this;
    }

    void speak();
}
