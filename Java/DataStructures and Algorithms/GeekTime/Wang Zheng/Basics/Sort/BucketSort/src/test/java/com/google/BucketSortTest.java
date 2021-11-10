package com.google;

import org.junit.jupiter.api.Test;

public class BucketSortTest {
    @Test
    public void testBucketSort() {
        BucketSort bucketSort = new BucketSort();
        bucketSort.bucketSort(new int[]{22,5,11,41,45,26,29,10,7,8,30,27,42,43,20});
    }
}
