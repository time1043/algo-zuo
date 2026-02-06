package com.time1043.started006;

// https://leetcode.cn/problems/find-peak-element/
public class FindPeakElement {
    public static int binarySearch(int[] nums) {
        // Consider the edge case
        int size = nums.length;
        if (size == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[size - 1] > nums[size - 2]) return size - 1;

        int left = 1, right = size - 2, middle, ans = -1;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (nums[middle - 1] > nums[middle]) right = middle - 1;
            else if (nums[middle] < nums[middle + 1]) left = middle + 1;
            else {
                ans = middle;
                break;
            }
        }
        return ans;
    }
}
