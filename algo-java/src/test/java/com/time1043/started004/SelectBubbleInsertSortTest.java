package com.time1043.started004;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectBubbleInsertSortTest {
    int epoch = 30;
    int maxSize = 30;  // 3: 1~3
    int maxValue = 60;  // 6: -6~6

    int[] generateArray(int maxSize, int maxValue) {
        // Math.random(): [0,1)
        // Math.random() * 3: [0, 3)
        // Math.random() * 3 + 1: [1, 4) = 1~3
        int size = (int) (Math.random() * maxSize + 1);
        int[] nums = new int[size];

        // Math.random(): [0,1)
        // Math.random() * (6*2+1) - 6: [-6, 7) = -6~6
        for (int i = 0; i < nums.length; i++)
            nums[i] = (int) (Math.random() * (maxValue * 2 + 1)) - maxValue;

        return nums;
    }

    void violenceSolution(int[] nums) {
        Arrays.sort(nums);
    }

    void check(Consumer<int[]> solution) {
        for (int i = 0; i < epoch; i++) {
            int[] input = generateArray(maxSize, maxValue);

            int[] expected = input.clone();
            int[] actual = input.clone();
            violenceSolution(expected);
            solution.accept(actual);

            // System.out.printf("Input   : %s%n", Arrays.toString(input));
            // System.out.printf("Expected: %s%n", Arrays.toString(expected));
            // System.out.printf("Actual  : %s%n", Arrays.toString(actual));
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void selectSort() {
        check(SelectBubbleInsertSort::selectSort);
    }

    @Test
    void bubbleSort() {
        check(SelectBubbleInsertSort::bubbleSort);
    }

    @Test
    void bubbleSort2() {
        check(SelectBubbleInsertSort::bubbleSort2);
    }

    @Test
    void insertSort() {
        check(SelectBubbleInsertSort::insertSort);
    }
}