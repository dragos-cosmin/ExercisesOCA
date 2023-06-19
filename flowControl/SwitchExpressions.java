package org.example.flowControl;

import java.util.Scanner;

public class SwitchExpressions {
    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input month as number from 1 to 12:");
        int month=sc.nextInt();
        boolean isLeapYear=false;

        switch (month){
            case 1,3,5,7,8,10,12-> System.out.println("31 days");
            case 4,6,9,11-> System.out.println("30 days");
            case 2->{
                if (!isLeapYear){
                    System.out.println("28 days");
                } else {
                    System.out.println("29 days");
                }

            }
            default-> System.out.println("Invalid month");
        }
    }
}
