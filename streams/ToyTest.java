package org.example.streams;


import java.util.ArrayList;
import java.util.List;

public class ToyTest {
    public static void main(String[] args) {
        List<Toy> toys=new ArrayList<>();
        toys.add(new Toy("RED",20));
        toys.add(new Toy("RED",10));
        toys.add(new Toy("BLUE",20));
        toys.add(new Toy("GREEN",15));
        toys.add(new Toy("RED",1));
        toys.add(new Toy("YELLOW",2));

        double weight=toys.stream()
                .filter(e->e.getShade()=="RED")
                .mapToInt(e->e.getSize())
                .sum();
        System.out.println(weight);
    }
}
