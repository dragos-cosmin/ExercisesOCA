package org.example.bitwise;

/**
 * @author dragos.cosmin
 **/
public class TestShift {
    public static String bitPattern(int value) {
        int BIT1_MASK = 1;
        final char[] bits = new char[32];
        for (int i = 31; i >= 0; i--) {
            if ((value & BIT1_MASK) == 1) {
                bits[i] = '1';
            } else {
                bits[i] = '0';
            }
            value >>>= 1;
        }
        return new String(bits);
    }

    public static void main(String[] args) {
        int num1 = 1357;
        int num2 = -1357;
        System.out.println("num1 (" + num1 + ") as a bit pattern: " + bitPattern(num1));
        System.out.println("num2 (" + num2 + ") as a bit pattern: " + bitPattern(num2));
        System.out.println("" + num1 + " >> 5 = (" + (num1 >> 5) + ") " + bitPattern(num1 >> 5));
        System.out.println("" + num2 + " >> 5 = (" + (num2 >> 5) + ") " + bitPattern(num2 >> 5));
        System.out.println("" + num1 + " >>> 5 = (" + (num1 >>> 5) + ") " + bitPattern(num1 >>> 5));
        System.out.println("" + num2 + " >>> 5 = (" + (num2 >>> 5) + ") " + bitPattern(num2 >>> 5));
        System.out.println("" + num1 + " << 5 = (" + (num1 << 5) + ") " + bitPattern(num1 << 5));
        System.out.println("" + num2 + " << 5 = (" + (num2 << 5) + ") " + bitPattern(num2 << 5));

    }
}
