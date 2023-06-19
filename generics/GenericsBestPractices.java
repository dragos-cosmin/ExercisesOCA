package org.example.generics;

import org.example.collections.Drink;
import org.example.collections.Food;
import org.example.collections.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dragos.cosmin
 **/
public class GenericsBestPractices {
    public static void main(String[] args) {
        Food cookie=new Food("Cookie", BigDecimal.valueOf(1.50));
        Drink coffee=new Drink("Coffee",BigDecimal.valueOf(2.10));
        Food cake=new Food("Cake",BigDecimal.valueOf(1.55));
        Drink water=new Drink("Water",BigDecimal.valueOf(1.05));
        List<Product> order1=new ArrayList<>();
        List<Product> order2=new ArrayList<>();
        addFood(order1,cookie);
        addDrink(order1,coffee);
        addFood(order2,cake);
        addDrink(order2,water);
        processOrder(order1);
        processOrder(order2);

    }

    public static void addFood(List<? super Food>order, Food food){order.add(food);}

    public static void addDrink(List<? super Drink>order, Drink drink){order.add(drink);}

    public static void processOrder(List<? extends Product> order){order.stream().forEach(product -> product.prepare());}

   public static void addProductAndProcessOrder(List<Product> order, Product product){
        order.add(product);
        order.stream().forEach(p -> p.prepare() );
   }

}
