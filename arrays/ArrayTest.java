package org.example.arrays;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        char[] charArray={'e','s','p','r','e','s','s','o','8','9','0'};
        System.out.println(charArray);
        System.arraycopy(charArray,2,charArray,6,5);
        System.out.println(charArray);
        System.out.println(charArray[8]);

        char[] b1={'a','c','m','e'};
        char[] b2={'t','o',' ',' ',' '};
        System.out.println(b1);
        System.out.println(b2);
        System.arraycopy(b1,2,b2,3,2);
        System.out.println(b2);

        char[] a1={'a','b','c','d'};
        char[] a2= Arrays.copyOf(a1,10);
        System.out.println(a2);

        char[] a3=Arrays.copyOfRange(a1,1,3);
        System.out.println(a3);

        String[] values=new String[5];
        Arrays.fill(values,2,4,"aaa");

        System.out.println(Arrays.toString(values));

        int x=Arrays.binarySearch(values,"aaa");
        System.out.println(x);

        String[] names1={"Mary","Ann","Jane","Tom"};
        String[] names2={"Mary","Ann","John","Tom"};
        System.out.println(Arrays.equals(names1,names2));
        System.out.println(Arrays.toString(names2));

        Arrays.sort(names2,new LengthComparator());
        System.out.println("sorted using LengthComparator "+Arrays.toString(names2));
        Arrays.sort(names2);
        System.out.println("sorted naturally "+Arrays.toString(names2));
    }

}
