package org.example.erroneousValueGuards;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dragos.cosmin
 **/
public class Examples {
    public static void main(String[] args) {
        final int MAX=Integer.MAX_VALUE;
        System.out.println(MAX);
//        int value=MAX+1;
        try {
            int value=Math.addExact(MAX,1);
            System.out.println(value);
        }catch (ArithmeticException e){
            Logger.getLogger(Examples.class.getName()).log(Level.WARNING,e.getMessage());
        }


        double badValue=1/Double.MIN_VALUE;
        double value=0;
        double divisor=0;
        if (!Double.isNaN(value/divisor)){
            System.out.println(value/divisor);
        } else {
            System.out.println("Result is NaN 0/0");
        }
        System.out.println(badValue);
        boolean infinite=Double.isInfinite(badValue);
        System.out.println(infinite);




    }
}
