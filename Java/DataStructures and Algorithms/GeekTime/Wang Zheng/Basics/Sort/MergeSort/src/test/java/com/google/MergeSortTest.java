package com.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] nums = {12, 12, 12, 12, 12};
        mergeSort.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
