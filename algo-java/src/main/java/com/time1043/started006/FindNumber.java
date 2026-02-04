package com.time1043.started006;

// https://leetcode.com/problems/binary-search/
public class FindNumber {
    public static int binarySearch(int[] nums, int target) {
        // Consider the edge case
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, middle;
        while (left <= right) {
            // middle = (left + right) / 2;
            middle = left + ((right - left) >> 1);
            if (nums[middle] > target) right = middle - 1;
            if (nums[middle] < target) left = middle + 1;
            if (nums[middle] == target) return middle;
        }
        return -1;
    }
}
