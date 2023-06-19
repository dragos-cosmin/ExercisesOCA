package org.example.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntrinsicLockAutomation {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        List<String> sList= Collections.synchronizedList(list);

        Runnable r=()->{
            String name=Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                sList.add(name+' '+i);
                }

            };
        Thread[] threads=new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(r);
            threads[i].start();
        }

        for (Thread t:
             threads) {
            try {
                t.join();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


            Iterator<String> i=sList.iterator();
            while (i.hasNext()){
                System.out.println(i.next());

        }



        }
    }

