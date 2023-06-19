package org.example.multithreading;

public class Some {
    public synchronized void a(){
        Thread ct=Thread.currentThread();
        System.out.println(ct.getName()+" method a");
    }
    public static synchronized void b(){
        Thread ct=Thread.currentThread();
        System.out.println(ct.getName()+" method b");
    }

    public void c(){
        Thread ct=Thread.currentThread();
        System.out.println(ct.getName()+" method c");
    }

    public static void main(String[] args) {
        Some s=new Some();
        Runnable r=()->{
            s.a();
            Some.b();
            synchronized (s){
                s.c();
            }
        };

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
