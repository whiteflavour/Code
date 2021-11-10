package com.google;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给 0-50 之间的数排序
 *
 * @author Liao
 * @date 2021-11-07
 */
public class BucketSort {
    public void bucketSort(int[] nums) {
        Map<Integer, List<Integer>> buckets = new HashMap<>();

        // 造桶
        for (int num : nums) {
            if (!buckets.containsKey(num / 10)) {
                buckets.put(num / 10, new ArrayList<>(Collections.singletonList(num)));
            } else {
                buckets.get(num / 10).add(num);
            }
        }

        // 对每个桶进行快速排序
        for (int i = 0; i < buckets.size(); ++i) {
            QuickSort quickSort = new QuickSort();
            int[] temp = buckets.get(i).stream().mapToInt(e -> e).toArray();
            quickSort.quickSort(temp);
            buckets.get(i).clear();
            buckets.get(i).addAll(Arrays.stream(temp).boxed().collect(Collectors.toList()));
        }

        // 将结果放入一个 list 中，方便输出
        List<Integer> sorted = new ArrayList<>();
        for (List<Integer> bucket : buckets.values()) {
            sorted.addAll(bucket);
        }
        System.out.println(sorted);
    }
}
