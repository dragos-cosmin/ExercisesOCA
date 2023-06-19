package org.example.collections;

import java.math.BigDecimal;

/**
 * @author dragos.cosmin
 **/
public class Food extends Product{
    public Food(String name) {
        super(name);
    }

    public Food(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Food{ name="+getName()+"}";
    }

    @Override
    public void prepare() {
        System.out.println("Serve "+getName());
    }
}
