package org.example.streams;

import org.example.collections.Drink;
import org.example.collections.Food;
import org.example.collections.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author dragos.cosmin
 **/
public class FilterExamples {
    public static void main(String[] args) {
        Predicate<Product> foodFilter = p -> p instanceof Food;
        Predicate<Product> priceFilter = p -> p.getPrice().compareTo(BigDecimal.valueOf(2)) < 0;
        List<Product> list =
                List.of(new Drink("Tea", BigDecimal.valueOf(2.5)), new Drink("Bear", BigDecimal.valueOf(1.5)),
                        new Food("Cookie", BigDecimal.valueOf(1.20)), new Food("Bread", BigDecimal.valueOf(2.50)));
        System.out.println("list of Food\n");
        list.stream().filter(foodFilter).forEach(System.out::println);
        System.out.println("\nList of non-Food or price less than 2\n");
        list.stream().filter(foodFilter.negate().or(priceFilter))
            .forEach(System.out::println);
    }
}
