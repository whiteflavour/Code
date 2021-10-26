package com.google;

/**
 * Merge sort after reading Wang Zheng's Geek Time by myself.
 *
 * @author Liao
 * @date 2021.10.22
 */
public class MergeSort {
    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 分治
     * @param nums the array to be sorted
     * @param left the left boundary
     * @param right the right boundary
     */
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    /**
     * 数组合并
     * @param nums
     * @param left
     * @param right
     * @param mid
     */
    private void merge(int[] nums, int left, int right, int mid) {
        // 两个临时数组
        int[] arr1 = new int[mid - left + 1];
        int[] arr2 = new int[right - mid];

        // 填充数组
        for (int i = 0, j = left; i < arr1.length; ++i, ++j) {
            arr1[i] = nums[j];
        }
        for (int i = 0, j = mid + 1; i < arr2.length; ++i, ++j) {
            arr2[i] = nums[j];
        }
        int indexOfNums = left;
        int indexOfArr1 = 0, indexOfArr2 = 0;

        // 将数组中的元素有序替换掉 nums 中的对应元素
        for (; indexOfNums <= right && indexOfArr1 < arr1.length && indexOfArr2 < arr2.length; ++indexOfNums) {
            if (arr1[indexOfArr1] < arr2[indexOfArr2]) {
                nums[indexOfNums] = arr1[indexOfArr1];
                ++indexOfArr1;
            } else {
                nums[indexOfNums] = arr2[indexOfArr2];
                ++indexOfArr2;
            }
        }

        // 填充临时数组中剩余元素
        if (indexOfArr1 == arr1.length) {
            for (int i = indexOfNums; indexOfArr2 < arr2.length; ++i) {
                nums[i] = arr2[indexOfArr2];
                ++indexOfArr2;
            }
        } else {
            for (int i = indexOfNums; indexOfArr1 < arr1.length; ++i) {
                nums[i] = arr1[indexOfArr1];
                ++indexOfArr1;
            }
        }
    }
}
