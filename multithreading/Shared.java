package org.example.multithreading;

public class Shared {
    public int x;
    public int y;

    public static void main(String[] args) {
        Shared s=new Shared();
        new Thread(()->{

            while (s.y<1){
                int x= s.x;

            }
            System.out.println("thread 1 - "+s.x+" "+s.y);

        },"thread 1").start();
        new Thread(()->{
            s.x=2;
            s.y=2;
            System.out.println("thread 2 - "+s.x+" "+s.y);
        },"thread 2").start();
        System.out.println(Thread.currentThread().getName()+" "+s.x+" "+s.y);
    }


}
