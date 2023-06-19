package org.example.streams;

import java.util.stream.Stream;

/**
 * @author dragos.cosmin
 **/
public class IntermediateExamples {
    public static void main(String[] args) {
        Stream<String> input = Stream.of("A", "C", "B", "D", "B", "D");
        input.distinct()
                .sorted()
                .skip(2)
                .forEach(s -> System.out.println(s.toLowerCase()));
        System.out.println();
        input = Stream.of("B", "C", "A", "E", "D", "F");
        input.takeWhile(s -> !s.equals("D"))
                .dropWhile(s -> !s.equals("C"))
                .limit(2)
                .forEach(s -> System.out.println(s.toLowerCase()));

    }
}
