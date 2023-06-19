package org.example.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dragos.cosmin
 **/
public class LiveLockExample {
    private double price;
    private int customerID;

    final Lock lock=new ReentrantLock();

    public LiveLockExample(int customerID, double price) {
        this.customerID = customerID;
        this.price = price;
    }

    public boolean charge(double amount) throws InterruptedException {
        if (this.lock.tryLock()){
            Thread.sleep(1000);
            price-=amount;
            return true;
        }else {
            return false;
        }
    }

    public boolean refund(double amount) throws InterruptedException {
        if(this.lock.tryLock()){
            Thread.sleep(1000);
            price+=amount;
            return true;
        }else {
            return false;
        }
    }

    public boolean process(LiveLockExample from, LiveLockExample to, double amount) throws InterruptedException {
        if (from.charge(amount)){
            System.out.println("Charging "+amount+" from "+customerID);
            if (to.refund(amount)){
                System.out.println("Refunding "+amount+" to "+customerID);
                return true;
            }else {
                from.refund(amount);
                System.out.println("Refunding amount: "+amount+" to "+customerID);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LiveLockExample Customer=new LiveLockExample(1,3000.0);
        LiveLockExample vendor=new LiveLockExample(2,3000.0);

        new Thread(()->{
            try {
                while (!Customer.process(Customer,vendor,3000.0))
                    continue;
            } catch (InterruptedException e) {
                Logger.getLogger(LiveLockExample.class.getName()).log(Level.SEVERE,null,e);
            }
        }).start();

        new Thread(()->{
            try {
                while (!vendor.process(vendor,Customer,3000.0))
                    continue;
            } catch (InterruptedException e) {
                Logger.getLogger(LiveLockExample.class.getName()).log(Level.SEVERE,null,e);
            }
        }).start();
    }
}
