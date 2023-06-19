package org.example.io;

import java.io.Console;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
To run application with console enabled open terminal and navigate to target/classes and run command:
java org.example.ConsoleSecurity
 */
public class ConsoleSecurity {
    public static void main(String[] args) {
        Console cs=System.console();
        if (cs==null){
            System.out.println("Console not supported");
            return;
        }
        PrintWriter out=cs.writer();
        out.println("Enter username:");
        String username= cs.readLine();
        String hash="";
        try {
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            out.println("Enter password:");
            byte[] digest= md.digest(String.valueOf(cs.readPassword()).getBytes());
            hash=new BigInteger(1,digest).toString(16);
        } catch (NoSuchAlgorithmException e) {
           out.println("Unable to create password hash");
        }
        System.out.println("Username: "+username);
        System.out.println("Password hash: "+hash);
    }
}
