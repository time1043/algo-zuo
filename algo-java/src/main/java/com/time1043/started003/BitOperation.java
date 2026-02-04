package com.time1043.started003;

import static com.time1043.started003.BinarySystem.printBinary;

public class BitOperation {
    public static void main(String[] args) {
        // | & ^
        int g = 0b0001010;
        int h = 0b0001100;
        printBinary(g | h);
        printBinary(g & h);
        printBinary(g ^ h);

        printBinary(10 | 12);
        printBinary(10 & 12);
        // printBinary(10 || 12);
        // printBinary(10 && 12);  // ❌ only bool

        boolean test1 = returnTrue() | returnFalse();
        System.out.println("test1: " + test1);
        boolean test2 = returnTrue() || returnFalse();  // shorts
        System.out.println("test2: " + test2);
        boolean test3 = returnFalse() & returnTrue();
        System.out.println("test3: " + test3);
        boolean test4 = returnFalse() && returnTrue();  // shorts
        System.out.println("test4: " + test4);

        // << signed left shift
        // >> signed right shift
        // >>> unsigned right shift
        int i = 0b0011010;
        printBinary(i);            // 00000000000000000000000000011010  // 26
        printBinary(i << 1);  // 00000000000000000000000000110100  // 52
        printBinary(i << 2);  // 00000000000000000000000001101000  // 104
        printBinary(i << 3);  // 00000000000000000000000011010000  // 208
        printBinary(i >> 2);  // 00000000000000000000000000000110  // 6
        printBinary(i >>> 2); // 00000000000000000000000000000110  // 6

        int j = 0b11110000000000000000000000000000;
        printBinary(j);             // 11110000000000000000000000000000  // -268435456
        printBinary(j >> 2);   // 11111100000000000000000000000000  // -67108864
        printBinary(j >>> 2);  // 00111100000000000000000000000000  // 1006632960

        int k = 10;
        printBinary(k);  // 10
        printBinary(k << 1);  // 20
        printBinary(k << 2);  // 40
        printBinary(k << 3);  // 80
        printBinary(k >> 1);  // 5
        printBinary(k >> 2);  // 2
        printBinary(k >> 3);  // 1
    }

    public static boolean returnTrue() {
        System.out.println("returnTrue");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("returnFalse");
        return false;
    }
}
