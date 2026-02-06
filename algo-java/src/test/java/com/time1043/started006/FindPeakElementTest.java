package com.time1043.started006;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FindPeakElementTest {
    int epoch = 300;
    int maxSize = 30;  // 3: 1~3
    int maxValue = 60;  // 6: -6~6

    int[] generateArray(int maxSize, int maxValue) {
        int size = (int) (Math.random() * maxSize + 1);
        int[] nums = new int[size];

        // Generate a random array where adjacent elements are not equal
        for (int i = 0; i < size; i++) {
            do {
                nums[i] = (int) (Math.random() * (maxValue * 2 + 1) - maxValue);
            } while (i > 0 && nums[i - 1] == nums[i]);
        }

        return nums;
    }

    List<Integer> violenceSolution(int[] nums) {
        List<Integer> peaks = new ArrayList<>();
        int size = nums.length;

        if (size == 1) {
            peaks.add(0);
            return peaks;
        }
        if (nums[0] > nums[1]) peaks.add(0);
        if (nums[size - 1] > nums[size - 2]) peaks.add(size - 1);

        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1) continue;
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) peaks.add(i);
        }

        return peaks;
    }

    @Test
    void binarySearch() {
        for (int i = 0; i < epoch; i++) {
            int[] input = generateArray(maxSize, maxValue);

            List<Integer> expected = violenceSolution(input);
            int actual = FindPeakElement.binarySearch(input);

            // System.out.printf("Input   : %s%n", Arrays.toString(input));
            // System.out.printf("Expected: %s%n", Arrays.toString(expected.toArray()));
            // System.out.printf("Actual  : %s%n", actual);
            assertTrue(expected.contains(actual));
        }
    }
}