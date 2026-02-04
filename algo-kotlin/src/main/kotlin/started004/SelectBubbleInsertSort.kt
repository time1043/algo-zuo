package com.time1043.section004sort

fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

class SelectBubbleInsertSort {
    fun selectionSort(nums: IntArray) {
        // Consider the boundary
        if (nums.isEmpty() || nums.size < 2) return

        // Calculate minIdx
        var minIdx = 0
        for (i in 0 until nums.size - 1) {
            minIdx = i
            for (j in i + 1 until nums.size) {
                if (nums[j] < nums[minIdx]) minIdx = j
            }
            nums.swap(i, minIdx)
        }
    }

    fun bubbleSort(nums: IntArray) {
        // Consider the boundary
        if (nums.isEmpty() || nums.size < 2) return

        // By comparing neighboring positions, the larger one bubbles backward
        for (i in nums.lastIndex downTo 1) {
            for (j in 0 until i) {
                if (nums[j] > nums[j + 1]) nums.swap(j, j + 1)
            }
        }
    }

    fun insertSort(nums: IntArray) {
        // Consider the boundary
        if (nums.isEmpty() || nums.size < 2) return

        // Ensure that 0~i is orderly, i=1~n-1
        for (i in 1..(nums.lastIndex)) {
            for (j in i downTo 1) {
                if (nums[j] < nums[j - 1]) nums.swap(j, j - 1)
            }
        }
    }
}