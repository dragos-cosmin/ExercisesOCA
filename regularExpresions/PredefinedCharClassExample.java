package org.example.regularExpresions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dragos.cosmin
 **/
public class PredefinedCharClassExample {
    public static void main(String[] args) {
        String t="Jo told me 20 ways to San Jose in 15 minutes.";
        System.out.println(t);

        Pattern p1=Pattern.compile("\\d\\d"); // \d (digit) [0-9];  \D [^0-9] no digits
        Matcher m1= p1.matcher(t);
        while (m1.find()){
            System.out.println("Found: "+m1.group());
        }

        Pattern p2=Pattern.compile("\\sin\\s"); // \s (white space) [ \r\t\n\f\0XB]
        Matcher m2= p2.matcher(t);
        while (m2.find()){
            System.out.println("Found: "+m2.group());
        }
        Pattern p3=Pattern.compile("\\Sin\\S"); // \S              [^ \r\t\n\f\0XB]
        Matcher m3= p3.matcher(t);
        while (m3.find()){
            System.out.println("Found: "+m3.group());
        }

        // \w (word char)  [a-zA-Z0-9_]
        // \W              [^a-zA-Z0-9_]

        /*   white space characters:
        \t: Tab character
        \n: New-line character
        \r: Carriage return
        \f: Form feed
        \0XB: Vertical tab
         */

    }
}
