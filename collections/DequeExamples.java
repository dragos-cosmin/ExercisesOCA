package org.example.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dragos.cosmin
 **/
public class DequeExamples {
    public static void main(String[] args) {
        Product p1=new Food("Cake");
        Product p2=new Drink("Tea");
        Product p3=new Drink("Coke");
        Deque<Product> menu=new ArrayDeque<>();
        Product nullProduct=menu.pollFirst();
        System.out.println(nullProduct);
        menu.offerFirst(p1);
        menu.offerFirst(p2);
        System.out.println(menu);
        Product tea=menu.pollFirst();
        System.out.println(tea);
        System.out.println(menu);
        Product cake1=menu.peekFirst();
        System.out.println(cake1);
        System.out.println(menu);
        menu.offerLast(p3);
        menu.offerLast(p1);
        System.out.println(menu);
        Product cake2=menu.pollLast();
        System.out.println(cake2);
        System.out.println(menu);
        menu.offerFirst(p1);
        System.out.println(menu);

    }
}
