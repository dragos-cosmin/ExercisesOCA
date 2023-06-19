package org.example.regularExpresions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dragos.cosmin
 **/
public class GreedinessExample {
    public static void main(String[] args) {
        String t="Longlonglong ago, in a galaxy far far away.";
        Pattern p1=Pattern.compile("ago.*far"); //ago followed by any character repeated one of more times until far that return the most characters
        Matcher m1= p1.matcher(t);
        if (m1.find()){
            System.out.println("Found: "+m1.group());
        }
        Pattern p2=Pattern.compile("ago.*?far"); // use ? to limit the result to the fewest characters needed to match the pattern
        Matcher m2= p2.matcher(t);
        if (m2.find()){
            System.out.println("Found: "+m2.group());
        }
    }
}
