package org.example.multithreading;

public class InterruptThread {
    public static void main(String[] args) {
        Runnable r=()->{
            Thread ct=Thread.currentThread();
            while (!ct.isInterrupted()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted exception");
                    return;
                }
            }
        };

        Thread t=new Thread(r);
        t.start();
        t.interrupt();

    }
}
