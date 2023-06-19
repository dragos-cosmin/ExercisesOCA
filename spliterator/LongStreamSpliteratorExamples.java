package org.example.spliterator;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.LongConsumer;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.lang.Math.sqrt;
import static java.util.stream.LongStream.range;
import static java.util.stream.StreamSupport.longStream;

/**
 * @author dragos.cosmin
 **/
public class LongStreamSpliteratorExamples {


    public static void main(String[] args) {
        Locale locale = new Locale("ro", "RO");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        long begin = 1;
        long window = 100_000;
        List<Long> primes = getNumPrimes(begin, begin + window);
        System.out.println("Number of splits: " +
                TestSpliterator.splitNum);
        //        System.out.println("\nNum of primes = " + newStream.count());
        System.out.println("\nNum of primes = " + primes.size());
        System.out.println("\nPrimes are: " + primes.stream().map(n -> numberFormat.format(n)).toList());
    }

    static List<Long> getNumPrimes(long begin, long end) {

        return longStream(new TestSpliterator(range(begin, end).spliterator()), true)
                .boxed()
                .filter(LongStreamSpliteratorExamples::isPrime)
                .toList();
    }

    static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;

        return range(2, (long) sqrt(n) + 1)
                .noneMatch(divisor -> n % divisor == 0);
    }

    public static class TestSpliterator implements Spliterator.OfLong {

        private final Spliterator.OfLong split;
        public static AtomicInteger splitNum = new AtomicInteger(1);

        public TestSpliterator(Spliterator.OfLong split) {
            this.split = split;
        }

        @Override
        public Spliterator.OfLong trySplit() {
            splitNum.incrementAndGet();
            return split.trySplit();
        }

        @Override
        public long estimateSize() {
            return split.estimateSize();
        }

        @Override
        public int characteristics() {
            return Spliterator.SIZED;
        }

        @Override
        public boolean tryAdvance(LongConsumer action) {
            return split.tryAdvance(action);
        }
    }
}
