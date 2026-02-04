package com.time1043.started006;

// Find the rightmost position of <=num in an ordered array
public class FindRight {
    public static int binarySearch(int[] nums, int target) {
        // Consider the edge case
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length -1, middle, ans = -1;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (nums[middle] > target) right = middle - 1;
            if (nums[middle] <= target) {
                ans = middle;
                left = middle + 1;
            }
        }
        return ans;
    }
}
