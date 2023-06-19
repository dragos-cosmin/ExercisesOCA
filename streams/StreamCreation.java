package org.example.streams;

import java.util.stream.IntStream;

/**
 * @author dragos.cosmin
 **/
public class StreamCreation {
    public static void main(String[] args) {
        String s="some text";
        IntStream charCodes1=s.chars();
        charCodes1.forEach(c-> System.out.print(c+", "));
        System.out.println();

        IntStream charCodes2=s.codePoints();
        charCodes2.peek(c-> System.out.print(c+"="))
                .mapToObj(c->String.valueOf((char) c))
                .forEach(System.out::println);
    }
}
