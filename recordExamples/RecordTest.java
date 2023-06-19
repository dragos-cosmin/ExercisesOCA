package org.example.recordExamples;

/**
 * @author dragos.cosmin
 **/
public class RecordTest {
    public static void main(String[] args) {
        Product p1=new Product("Tea",1.99);
        Product p2=new Product("Tea",1.99);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p1.name());
        System.out.println(p1);
    }
}
