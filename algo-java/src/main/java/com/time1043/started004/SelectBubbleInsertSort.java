package com.time1043.started004;

// https://leetcode.com/problems/sort-an-array/
public class SelectBubbleInsertSort {
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void selectSort(int[] nums) {
        // Consider the boundary
        if (nums == null || nums.length < 2) return;

        // Calculate minIdx
        int minIdx;
        for (int i = 0; i < nums.length - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) minIdx = j;
            }
            // swap(nums, i, minIdx);
            if (minIdx != i) swap(nums, i, minIdx);
        }
    }

    public static void bubbleSort(int[] nums) {
        // Consider the boundary
        if (nums == null || nums.length < 2) return;

        // By comparing neighboring positions, the larger one bubbles backward
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
    }

    public static void insertSort(int[] nums) {
        // Consider the boundary
        if (nums == null || nums.length < 2) return;

        // Ensure that 0~i is orderly, i=1~n-1
        for (int i = 1; i <= (nums.length - 1); i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) swap(nums, j, j - 1);
                else break;
            }
        }
    }
}
