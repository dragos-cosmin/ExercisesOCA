package org.example.regularExpresions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dragos.cosmin
 **/
public class QuantifiersExample {
    public static void main(String[] args) {
        String t="Longlonglong ago, in a galaxy far far away.";

        Pattern p1=Pattern.compile("ago.*"); //ago followed by any character repeated one of more times
        Matcher m1= p1.matcher(t);
        if (m1.find()){
            System.out.println("Found: "+m1.group());
        }
        Pattern p2=Pattern.compile("gal.{3}"); // gal followed by any character repeated 3 times
        Matcher m2= p2.matcher(t);
        if (m2.find()){
            System.out.println("Found: "+m2.group());
        }
        Pattern p3=Pattern.compile("(long){2}"); // group long repeated 2 times
        Matcher m3= p3.matcher(t);
        if (m3.find()){
            System.out.println("Found: "+m3.group());
        }
        /*
           -    *  the previous character is repeated zero or more times
           -    +  the previous character is repeated one or more times
           -    ?  the previous character must appear once or not at all
           -   {n} the previous character appears exactly n times
           - {m,n} the previous character appears from m to n times
           -  {m,} the previous character appears m or more times
           - (xx){n} this group of characters repeats n times
         */
    }
}
