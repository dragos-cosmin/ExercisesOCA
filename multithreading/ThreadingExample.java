package org.example.multithreading;

public class ThreadingExample {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();
        int threadNo=r.availableProcessors();
        System.out.println("number of available threads: "+threadNo);

        Runnable runnable=()->{

            for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName()+" "+i);
                    }


        };

        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);
        Thread t3=new Thread(runnable);

        t1.start();

        t2.start();

        t3.start();




    }
}
