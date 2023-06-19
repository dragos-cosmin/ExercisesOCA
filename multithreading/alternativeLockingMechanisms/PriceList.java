package org.example.multithreading.alternativeLockingMechanisms;

import org.example.collections.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author dragos.cosmin
 **/
public class PriceList {
    private final List<Product> menu=new ArrayList<>();
    private final ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
    private final Lock rl=rwl.readLock();
    private final Lock wl= rwl.writeLock();

    public Product get(int id){
        rl.lock();
        try {
            return menu.stream().filter(product -> product.getId()==id).findFirst().orElseThrow();
        } catch (Exception e) {
            System.out.println("Product with id: "+id+" not found");
            return null;
        } finally {
            rl.unlock();
        }
    }

    public void add(Product product){
        wl.lock();
        try {
            menu.add(product);
        } catch (Exception e) {
            System.out.println("Could not add product");
        }finally {
            wl.unlock();
        }
    }
}
