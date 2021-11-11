package com.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CountingSortTest {
    @Test
    public void testCountingSort() {
        CountingSort countingSort = new CountingSort();
        int[] nums = new int[]{2,5,3,0,2,3,0,3};
        countingSort.countingSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
