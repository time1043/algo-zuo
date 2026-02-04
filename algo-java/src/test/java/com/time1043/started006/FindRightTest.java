package com.time1043.started006;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindRightTest {
    int epoch = 300;
    int maxSize = 30;  // 3: 1~3
    int maxValue = 60;  // 6: -6~6

    public record TestCase(int[] nums, int target) {
    }

    TestCase generateArray(int maxSize, int maxValue) {
        // nums
        int size = (int) (Math.random() * maxSize + 1);
        int[] nums = new int[size];
        for (int i = 0; i < size; i++)
            nums[i] = (int) (Math.random() * (maxValue * 2 + 1)) - maxValue;
        Arrays.sort(nums);  // sort

        // target
        int target = Math.random() > 0.5
                ? nums[(int) (Math.random() * nums.length)]
                : (int) (Math.random() * (maxValue * 2 + 1)) - maxValue;

        return new TestCase(nums, target);
    }

    int violenceSolution(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--)
            if (nums[i] <= target) return i;
        return -1;
    }

    @Test
    void binarySearch() {
        for (int i = 0; i < epoch; i++) {
            TestCase input = generateArray(maxSize, maxValue);
            int[] nums = input.nums;
            int target = input.target;

            int expected = violenceSolution(nums, target);
            int actual = FindRight.binarySearch(nums, target);

            // System.out.printf("Input   : %s, %d%n", Arrays.toString(nums), target);
            // System.out.printf("Expected: %s%n", expected);
            // System.out.printf("Actual  : %s%n", actual);
            assertEquals(expected, actual);
        }
    }
}