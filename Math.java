package org.example;

import java.util.Arrays;

/**
 * @author dragos.cosmin
 **/

//run from terminal using command: java MATH.java 10 20 30 and result should be 60
public class Math {
    public static void main(String[] args) {
        Integer sum= Arrays.stream(args)
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);
    }
}
