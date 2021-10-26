package com.google;

/**
 * Quick sort after reading Wang Zheng's Geek Time by myself.
 *
 * @author Liao
 * @date 2021.10.22
 */
public class QuickSort {
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 分治
     * @param nums the array to be sorted
     * @param start start index
     * @param guard 一般选取该区域的最后一个元素作为哨兵
     */
    private void quickSort(int[] nums, int start, int guard) {
        int i = start;
        if (start >= guard) {
            return;
        }
        for (int j = start; j <= guard; ++j) {
            if (nums[j] <= nums[guard]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++i;
            }
        }
        quickSort(nums, start, i - 2);
        quickSort(nums, i, guard);
    }
}
