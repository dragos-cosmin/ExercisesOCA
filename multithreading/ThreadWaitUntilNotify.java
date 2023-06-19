package org.example.multithreading;

public class ThreadWaitUntilNotify {
    public static void main(String[] args) {
        Object obj=new Object();
        Runnable r=()->{
            try {
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName()+" enter wait time");
                    obj.wait(); // puts thread in waiting state until notified
                    System.out.println(Thread.currentThread().getName()+" exit wait time");
//                    obj.notify(); // wakes up one thread. Put here to release all threads
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception");
            }
        };

        Thread t0=new Thread(r,"t0");
        t0.setPriority(1);
        Thread t1=new Thread(r,"t1");
        t1.setPriority(8);
        Thread t2=new Thread(r,"t2");
        t2.setPriority(3);
        t0.start();
        t1.start();
        t2.start();

        try {

            System.out.println(Thread.currentThread().getName()+" thread sleep");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" thread end sleep");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception in main");
        }
        synchronized (obj){
//            obj.notify();   //wakes up one thread (stochastic)
            obj.notifyAll();  // wakes up all threads
        }
    }
}
