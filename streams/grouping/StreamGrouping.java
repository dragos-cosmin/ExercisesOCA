package org.example.streams.grouping;

import org.example.collections.Drink;
import org.example.collections.Food;
import org.example.collections.Product;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author dragos.cosmin
 **/
public class StreamGrouping {
    public static void main(String[] args) {
        // given a String
        // find the number of character occurrences
        String input = "ilovejavatechie";

        //transform String in array

        String[] result = input.split("");
        System.out.println(Arrays.toString(result));

        // using Arrays.stream(String[]...) and groupingBy we obtain a Map with each character as key and the characters as values
        Map<String, List<String>> map = Arrays.stream(result)
                                              .collect(Collectors.groupingBy(s -> s));
        System.out.println(map);

        // to count each occurrence

        Map<String, Long> mapResult = Arrays.stream(result)
                                            .collect(Collectors.groupingBy(Function.identity(),
                                                    Collectors.counting()));
        System.out.println(mapResult);

        List<Product> list =
                List.of(new Drink("Tea", BigDecimal.valueOf(2.5)), new Drink("Bear", BigDecimal.valueOf(1.5)),
                        new Food("Cookie", BigDecimal.valueOf(1.20)), new Food("Bread", BigDecimal.valueOf(2.50)));
        // summarizingDouble calculates summary values average, min, max and sum and count
        DoubleSummaryStatistics stats = list.stream()
                                            .collect(Collectors.summarizingDouble(p -> p.getPrice().doubleValue()));
        System.out.println(stats);
        // mapping and joining elements
        String names = list.stream()
                           .collect(Collectors.mapping(p -> p.getName(), Collectors.joining(", ")));
        System.out.println(names);
        // gathering stream elements in a collection
        List<Product> drinks = list.stream()
                                   .filter(p -> p instanceof Drink)
                                   .collect(Collectors.toList());
        System.out.println(drinks);
        // add finisher function to a collector to perform conversion of the collect result
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.UK);
        String s2 = list.stream()
                        .collect(
                                Collectors.collectingAndThen(
                                        Collectors.averagingDouble(p -> p.getPrice().doubleValue()),
                                        n -> fmt.format(n)));
        System.out.println(s2);
        //partitioning
        Map<Boolean, List<Product>> producTypes = list.stream()
                                                      .collect(Collectors.partitioningBy(p -> p instanceof Drink));
        System.out.println(producTypes);
        Map<String, List<Product>> productGroups = list.stream()
                                                       .collect(Collectors.groupingBy(p -> p.getClass()
                                                                                            .getSimpleName()));
        System.out.println(productGroups);
    }
}
