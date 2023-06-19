package org.example.regularExpresions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dragos.cosmin
 **/
public class CustomCharClassExamples {
    public static void main(String[] args) {
        String t="It was the best of times.";

        Pattern p1=Pattern.compile("w.s");  // . any character letter or digit or special character except end-of-line markers
        Matcher m1= p1.matcher(t);
        if (m1.find()){
            System.out.println("Found: "+m1.group());
        }

        Pattern p2=Pattern.compile("w[abc]s");  // [abc] any of a, b, c in that position
        Matcher m2= p2.matcher(t);
        if (m2.find()){
            System.out.println("Found: "+m2.group());
        }

        Pattern p3=Pattern.compile("t[^eou]mes"); // [^eou] any except for e, o, u in hat position
        Matcher m3= p3.matcher(t);
        if (m3.find()){
            System.out.println("Found: "+m3.group());
        }
    }

    // [a-c] a range of characters in that case a, b, c
    //  |  alternation, an "or" indicator
}
