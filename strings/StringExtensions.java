package org.example.strings;

/**
 * @author dragos.cosmin
 **/
public class StringExtensions {
    public static void main(String[] args) {
        String sample="\n\t hello \u2005";
        System.out.println(sample);
        System.out.println(sample.strip().equals("hello"));

        String sample2=" ";
        System.out.println(sample2.isBlank());

        String sample3="this is data\n use data to test \n complete your analytics";
        long count=sample3.lines().count();
        System.out.println("counter="+count);
    }
}
