package org.example.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author dragos.cosmin
 **/
public class NonBlockingConcurrencyAutomation {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        List<String> copyOnWriteList=new CopyOnWriteArrayList<>(list);
        Runnable r=()->{
            String name=Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                copyOnWriteList.add(name+' '+i);
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


            Iterator<String> i=copyOnWriteList.iterator();
            while (i.hasNext()){
                System.out.println(i.next());

        }
    }
}
