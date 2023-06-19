package org.example.generics;

import org.example.collections.Drink;
import org.example.collections.Food;
import org.example.collections.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dragos.cosmin
 **/
public class GenericsAndTypeHierarchy {
    public static void main(String[] args) {
        List<Food> foods= new ArrayList<>();
        List values=foods;
        List<Product> products=values;
        products.add(new Drink("Tea"));
        Drink x1=(Drink) values.get(0);
        Food x2=foods.get(0);
        System.out.println(x1);
//        System.out.println(foods.get(0));
        System.out.println(x2);
    }
}
