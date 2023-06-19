package org.example.streams;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author dragos.cosmin
 **/
public class ParallelExamples {

    public static void main(String[] args) {
Instant start, stop;
        List<Long> numbers= LongStream.range(1,100_000_000).boxed().toList();
        start=Instant.now();
        long result= numbers.stream().mapToLong(s->s).sum();
        System.out.println(result);
        stop=Instant.now();
        System.out.println(Duration.between(start,stop).toMillis());

        start=Instant.now();
        result=numbers.stream().parallel().collect(Collectors.summingLong(s->s));
        System.out.println(result);
        stop=Instant.now();
        System.out.println(Duration.between(start,stop).toMillis());
    }
}
