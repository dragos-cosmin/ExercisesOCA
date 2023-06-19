package org.example.streams;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class PrimitiveToObjConversion {
    public static void main(String[] args) {
        int x= DoubleStream.of(1.234,1.0,3.987,0.321,4.0)
                .filter(n->n!=(int)n)
                .boxed()
                .map(n-> BigDecimal.valueOf(n))
                .map(n->n.round(new MathContext(1, RoundingMode.HALF_UP)))
                .mapToInt(n-> n.intValue())
                .peek(n->System.out.print(n+", "))
                .sum();
        System.out.println("\nSum is "+x);

        CharSequence obj=new StringBuilder(new String("String"));
        System.out.println(obj.getClass());

        List<String> names=Stream.of("Fred","Jim","Sheila")
                .parallel()
                .collect(Collectors.toList());
        System.out.println(names);

        System.out.println(Stream.of("Dan","Bob","Sheila")
                .parallel()
                .collect(StringBuilder::new,StringBuilder::append
                ,StringBuilder::append).toString());


        System.out.println(Stream.of("Dan","Paul","Bob")
                .parallel()
                .collect(Collectors.joining(", ")));

        System.out.println(Stream.of("Fred","Jim","Sheila")
                .reduce("",(a,b)->a+", "+b));

        Stream.of("Fred","Tom","Jane")
                .reduce((a,b)->a+", "+b)
                .ifPresent(System.out::println);


    }
}
