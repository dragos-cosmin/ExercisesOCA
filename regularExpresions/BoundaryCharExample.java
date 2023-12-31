package org.example.regularExpresions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dragos.cosmin
 **/
public class BoundaryCharExample {
    public static void main(String[] args) {
        String t="it was the best of times or it was the worst of times";

        Pattern p1=Pattern.compile("^it.*?times"); // ^ matches the beginning of the line
        Matcher m1= p1.matcher(t);
        if (m1.find()){
            System.out.println("Found: "+m1.group());
        }
        Pattern p2=Pattern.compile("\\sit.*times$"); // $ matches the end of the line
        Matcher m2= p2.matcher(t);
        if (m2.find()){
            System.out.println("Found: "+m2.group());
        }
        Pattern p3=Pattern.compile("\\bor\\b.{3}"); // \b matches the start or the end of the word
                                                         // \B does not match the start or the end of the word
        Matcher m3= p3.matcher(t);
        if (m3.find()){
            System.out.println("Found: "+m3.group());
        }
    }
}
