package com.time1043.started007;

public class Complexity {
    public static void measure(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long end = System.currentTimeMillis();
        System.out.printf("The running time: %s ms %n", (end - start));
    }

    // O(n^2)
    public static void doubleCompletelyLoop(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {

            }
        }
    }

    // O(n^2)
    public static void doubleLoop(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = i; j <= size; j++) {

            }
        }
    }

    // O(n * log n)
    public static void harmonicSeries(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = i; j <= size; j += i) {

            }
        }
    }

    // public static void harmonicSeries() {
    //     long start = System.currentTimeMillis();
    //
    //     int size = 20000000;
    //     for (int i = 1; i <= size; i++) {
    //         for (int j = i; j <= size; j += i) {
    //
    //         }
    //     }
    //
    //     long end = System.currentTimeMillis();
    //     System.out.printf("The running time: %s ms %n", (end - start));
    // }

    public static void main(String[] args) {
        // harmonicSeries();
        // measure(Complexity::harmonicSeries);
        int size = 200000;
        measure(() -> harmonicSeries(size));  // 2 ms
        measure(() -> doubleLoop(size));  // 4621 ms
        measure(() -> doubleCompletelyLoop(size));  // 9217 ms
    }
}
