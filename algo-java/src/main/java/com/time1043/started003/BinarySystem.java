package com.time1043.started003;

public class BinarySystem {
    public static void printBinary(int num) {
        // int: num & (1 < 31)
        // long: num & (1L << 63)
        // example: 0110 1100
        // (1<<7)   1000 0000 &= 0000 0000
        // (1<<6)   0100 0000 &= 0100 0000
        // (1<<5)   0010 0000 &= 0010 0000
        // (1<<4)   0001 0000 &= 0000 0000
        System.out.print(num + ": ");
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");  // ✅
            // System.out.print((num & (1 << i)) != 0 ? "1" : "0");  // ✅
            // System.out.print((num & (1 << i)) == 1 ? "1" : "0");  // ❌
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 78;
        printBinary(a);  // 78
        printBinary(~a);  // -79
        printBinary(~a + 1);  // -78
        printBinary(~(a - 1));  // -78
        // -1 ~; ~ +1 (inverse operation and equivalent)

        int b = -6;
        printBinary(b);  // -6
        printBinary(~b + 1);  // 6

        int c = 0b01001110;
        printBinary(c);

        int d = 0x4e;
        printBinary(d);

        int e = Integer.MIN_VALUE;
        printBinary(e);  // -2147483648
        printBinary(~e + 1);  // -2147483648

        int f = Integer.MAX_VALUE;
        printBinary(f);  // 2147483647
        printBinary(~f + 1);  // -2147483647
    }
}
