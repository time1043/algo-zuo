package com.time1043.started006;

// Find the leftmost position of >=num in an ordered array
// https://leetcode.com/problems/search-insert-position/description/ ⚠️
public class FindLeft {
    public static int binarySearch(int[] nums, int target) {
        // Consider the edge case
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, middle, ans = -1;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (nums[middle] < target) left = middle + 1;
            if (nums[middle] >= target) {
                ans = middle;
                right = middle - 1;
            }
        }
        return ans;
    }
}
