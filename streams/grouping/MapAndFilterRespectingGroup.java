package org.example.streams.grouping;

import org.example.collections.Drink;
import org.example.collections.Food;
import org.example.collections.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dragos.cosmin
 **/
public class MapAndFilterRespectingGroup {
    public static void main(String[] args) {
        Customer bob=new Customer("Bob");
        Customer joe=new Customer("Joe");
        Order o1=new Order(joe, LocalDate.of(2018,11,21), List.of(new Drink("Tea", BigDecimal.valueOf(1.99)),
                new Food("Cake",BigDecimal.valueOf(2.99))));
        Order o2=new Order(bob, LocalDate.of(2018,11,21), List.of(new Drink("Coffee", BigDecimal.valueOf(1.99))));
        Order o3=new Order(joe, LocalDate.of(2018,11,22), List.of(new Drink("Coffee", BigDecimal.valueOf(1.99)),
                new Food("Cake",BigDecimal.valueOf(2.99))));
        List<Order>orders=new ArrayList<>();
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        Map<Customer, Set<Product>> customerProducts = orders.stream()
                                                             .collect(Collectors.groupingBy(o -> o.getCustomer(),
                                                                     Collectors.flatMapping(o -> o.getItems().stream(),
                                                                             Collectors.toSet())));
        System.out.println(customerProducts);

        Map<Customer, Set<Order>> customerOrderOnDate = orders.stream()
                                                              .collect(Collectors.groupingBy(o -> o.getCustomer(),
                                                                      Collectors.filtering(o -> o.getDate()
                                                                                                 .equals(LocalDate.of(2018, 11, 22)),
                                                                              Collectors.toSet())));
        System.out.println(customerOrderOnDate);

    }
}
