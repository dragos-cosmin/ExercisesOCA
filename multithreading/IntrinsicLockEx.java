package org.example.multithreading;

import java.util.ArrayList;
import java.util.List;

public class IntrinsicLockEx {
    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList<>();
        Runnable r=()->{
            String name=Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                synchronized (list){
                    list.add(name+' '+i);
                    System.out.println("add to list: "+name+' '+i);
                }

            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(r,"thread-"+(i+1)).start();

        }
        Thread.sleep(500);  // if not put, the threads have no time to complete task and the list on main thread is empty
        System.out.println("end of threads");
        System.out.println("List is:");
        list.forEach(System.out::println);

    }

}
