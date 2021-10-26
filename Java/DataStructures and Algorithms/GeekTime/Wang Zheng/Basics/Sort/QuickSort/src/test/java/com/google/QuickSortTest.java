package com.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        int[] nums = {2,1,4,5,3,0,8,6,7,-8,-2,-3,-1,-5,-4};
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
