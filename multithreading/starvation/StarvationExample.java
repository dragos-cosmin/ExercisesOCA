package org.example.multithreading.starvation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dragos.cosmin
 **/
public class StarvationExample {
    public static void main(String[] args) {
        ThreadWorker worker=new ThreadWorker();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    worker.work();
                }catch (InterruptedException e){
                    Logger.getLogger(StarvationExample.class.getName()).log(Level.SEVERE,null,e);
                }
            }).start();
        }
    }
}
