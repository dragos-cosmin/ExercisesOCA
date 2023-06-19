package org.example;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.lang.Math.sqrt;
import static java.util.stream.LongStream.range;

/**
 * @author dragos.cosmin
 **/
public class PrimeNumbers {
    public static void main(String[] args) {
        primeNumbers(100);
    }

    public static  boolean isPrime(long n) {
        if (n<2) return false;
        if(n==2 || n==3) return true;

        return range(2, (long) sqrt(n)+1)
                .noneMatch(divisor -> n % divisor == 0);
    }

    public static void primeNumbers(long number){
        List<Long> primes=range(1,number+1)
                .boxed()
                .peek(s-> System.out.print(s+", "))
                .filter(PrimeNumbers::isPrime)
                .toList();
        System.out.println("\n"+primes);
        System.out.println("Number of primes is "+primes.size());

    }
}
