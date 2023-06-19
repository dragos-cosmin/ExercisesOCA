package org.example.multithreading;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        Runnable task=()->{
            String name=Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                if (Thread.currentThread().isInterrupted()){
                    return;
                }
                System.out.println(name+" "+i+" "+ Instant.now());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Thread "+name+" was interrupted while sleeping");
                    return;
                }
            }
        };

        ExecutorService es= Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            es.execute(task);
        }
        es.shutdown();
        boolean allTaskedTerminated=false;

        try {
            allTaskedTerminated=es.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }finally {
            if (!allTaskedTerminated){
                es.shutdown();
            }
        }
        System.out.println("All thread terminated "+allTaskedTerminated);
    }
}
