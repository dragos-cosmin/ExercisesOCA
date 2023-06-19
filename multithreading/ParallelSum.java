package org.example.multithreading;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ParallelSum {
    static AtomicLong sum1= new AtomicLong();
    static AtomicLong sum2=new AtomicLong();
    static  AtomicLong sum3=new AtomicLong();
    static AtomicLong sum4=new AtomicLong();
    public static final int MAX_MEMB=Integer.MAX_VALUE;

    public static void main(String[] args) {
        int memb=900_000;
        System.out.println("Max memb: "+MAX_MEMB);
        System.out.println(sum1.longValue());
        System.out.println(sum2.longValue());
        System.out.println(sum3.longValue());
        System.out.println(sum4.longValue());

        long sum=0;
        int[] numbers=new int[memb];
        Instant time;


        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=i;

        }

        time=Instant.now();
        for (int i = 0; i < numbers.length; i++) {
            sum+=numbers[i];
        }
        if (sum>MAX_MEMB){
            System.out.println("Members too large");
        }
        System.out.println("Sum = "+sum);

        System.out.println( (Duration.between(time,Instant.now()).toMillis()) +" ms");



        time=Instant.now();
        int normMemb= numbers.length/4;
        int remainMem=numbers.length-3*normMemb;
        System.out.println("NM: "+normMemb);
        System.out.println("RM: "+remainMem);
        Thread th1=new Thread(()->{
            for (int i = 0; i < normMemb; i++) {
                sum1.addAndGet(numbers[i]);
            }
        });
        th1.start();
        Thread th2=new Thread(()->{
            for (int i = 0 ;i < normMemb; i++) {
                sum2.addAndGet(numbers[i+normMemb]);
            }
        });
        th2.start();
        Thread th3=new Thread(()->{
            for (int i = 0; i < normMemb; i++) {
                sum3.addAndGet(numbers[i+normMemb*2]);
            }
        });
        th3.start();
        Thread th4=new Thread(()->{
            for (int i = 0; i < remainMem; i++) {
                sum4.addAndGet(numbers[i+normMemb*3]);
            }
        });
        th4.start();
        System.out.println("sum1: "+sum1.longValue());
        System.out.println("sum2: "+sum2.longValue());
        System.out.println("sum3: "+sum3.longValue());
        System.out.println("sum4: "+sum4.longValue());
        System.out.println("sum: "+(sum1.longValue()+sum2.longValue()+sum3.longValue()+sum4.longValue()));
        System.out.println( (Duration.between(time,Instant.now()).toMillis()) +" ms");


    }


}
