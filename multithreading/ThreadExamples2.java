package org.example.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ThreadExamples2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList<>();
        Runnable r=()->{
            String name=Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                list.add(name+' '+i);
                System.out.println(name+' '+i);
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(r).start();
        }
        Thread.sleep(10000);
        System.out.println("end of threads");
        list.stream()
                .forEach(System.out::println);
    }
}
