package org.example.flowControl;

import java.util.Scanner;

public class YieldExample {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input month as number from 1 to 12:");
        int month = sc.nextInt();
        System.out.println("Input year: ");
        int year = sc.nextInt();

        boolean isLeapYear = LeapYear.isLeapYear(year);

        int daysNumber = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                if (!isLeapYear) {
                    yield 28;
                } else {
                    yield 29;
                }

            }
            default -> 0;
        };
        System.out.println("Month has " + daysNumber + " days");


    }

    public static class LeapYear {
        public static boolean isLeapYear(final int year) {
            return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
        }

        private static boolean isDivisible(final int year, final int denominator) {
            return year % denominator == 0;
        }


    }

}
