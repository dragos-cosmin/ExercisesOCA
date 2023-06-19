package org.example.multithreading.starvation;

/**
 * @author dragos.cosmin
 **/
public class ThreadWorker {
    private String name;

    public synchronized void work() throws InterruptedException {
        boolean condition=true;
        name=Thread.currentThread().getName();
        while (condition){
            try {
                System.out.println(name+" is working");
                Thread.sleep(10000);
                condition=false;
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
