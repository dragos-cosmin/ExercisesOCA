package org.example.streams;

import org.example.collections.Drink;
import org.example.collections.Food;
import org.example.collections.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

/**
 * @author dragos.cosmin
 **/
public class MappingExamples {
    public static void main(String[] args) {
        Function<Product,String> nameMapper=p->p.getName();
        UnaryOperator<String> trimMapper=n->n.trim();
        ToIntFunction<String> lengthMapper=n->n.length();
        List<Product> list=List.of(new Drink("Tea", BigDecimal.valueOf(2.5)),new Drink("Bear",BigDecimal.valueOf(1.5)),
                new Food("Cookie",BigDecimal.valueOf(1.20)),new Food("Bread",BigDecimal.valueOf(2.50)));
        // total names lengths of all products
        int result=list.stream()
                .map(nameMapper.andThen(trimMapper))
                .mapToInt(lengthMapper)
                .sum();
        System.out.println(result);
    }
}
