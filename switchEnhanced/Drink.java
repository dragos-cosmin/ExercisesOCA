package org.example.switchEnhanced;

import java.math.BigDecimal;

/**
 * @author dragos.cosmin
 **/
public class Drink extends Product {
    public Drink(String name) {
        super(name);
    }

    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Drink{ name="+getName()+"}";
    }

    @Override
    public void prepare() {
        System.out.println("Pour "+getName());
    }


    public void pour() {
        System.out.println("Pouring "+getName());
    }
}
