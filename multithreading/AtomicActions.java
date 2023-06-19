package org.example.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicActions {
//    public int x;
    public AtomicInteger x=new AtomicInteger();

    public static void main(String[] args) {
        AtomicActions s=new AtomicActions();
        Runnable r=()->{
            int z=0;
            while (z<10){
//                z=++s.x;
                z=s.x.incrementAndGet();

            }
            System.out.println(Thread.currentThread().getName()+" "+z);
        };
        for (int i = 0; i < 50; i++) {
            new Thread(r).start();
        }
    }
}
