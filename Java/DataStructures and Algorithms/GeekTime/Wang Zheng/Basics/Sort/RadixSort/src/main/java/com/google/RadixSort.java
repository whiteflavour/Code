package com.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 给手机号码排序
 *
 * @author Liao
 * @date 2021-11-12
 */
public class RadixSort {
    public void radixSort(int[] nums) {
        // 将原来位置的索引与原来的完整的电话号码绑定
        Map<Integer, Integer> indexMap = new HashMap<>();

        int lengthOfPhoneNum = 5;

        // 按位分别排序
        for (int i = 0; i < lengthOfPhoneNum; ++i) {
            int n = nums.length;

            // 存放每次取完最后一位后将最后一位砍掉的值
            int[] cut = new int[n];
            for (int m = 0; m < n; ++m) {
                cut[m] = i == 0 ? nums[m] : (int) (nums[m] / Math.pow(10, i));
            }

            // 存放电话号码的最后一位
            int[] single = new int[n];
            for (int j = 0; j < n; ++j) {
                indexMap.put(j, nums[j]);
                single[j] = cut[j] % 10;
            }

            // 按位进行计数排序，但是给最后排完序的数组存放排完序后
            // 对应的原来的索引，方便取得最后排序后原来电话号码的值
            CountingSort countingSort = new CountingSort();
            countingSort.countingSort(single);

            // 获取对应索引的原始电话号码
            for (int k = 0; k < n; ++k) {
                single[k] = indexMap.get(single[k]);
            }

            // 为了保证 nums 可用，将排序后的结果 single 复制到 nums
            System.arraycopy(single, 0, nums, 0, n);
        }
    }
}
