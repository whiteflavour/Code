package com.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RadixSortTest {
    @Test
    public void testRadixSort() {
        RadixSort radixSort = new RadixSort();
        int[] nums = new int[9];
        for (int i = 0; i < 9; ++i) {
            nums[i] = ThreadLocalRandom.current().nextInt(10000, 100000);
        }
        System.out.println(Arrays.toString(nums));
        radixSort.radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
