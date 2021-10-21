package com.google;

public class MergeSort {
    public void mergeSort(int[] nums) {

    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid - 1);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    public void merge(int[] nums, int left, int right, int mid) {
        int[] arr1 =
        for (int i = left; i <= right; ++i) {

        }
    }
}
