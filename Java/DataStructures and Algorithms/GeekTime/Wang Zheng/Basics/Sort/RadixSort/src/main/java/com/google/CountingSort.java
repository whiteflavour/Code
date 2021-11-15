package com.google;

/**
 * 给手机号按位排序，针对这个问题对原始的计数排序进行了适当的改进。
 *
 * @author Liao
 * @date 2021-11-12
 */
public class CountingSort {
    public void countingSort(int[] nums) {
        int n = nums.length;

        // 每位的范围：0-9
        int maxRange = 10;

        int[] count = new int[maxRange];
        int[] sorted = new int[n];

        // 计数
        for (int num : nums) {
            ++count[num];
        }

        // 存放小于等于索引值的号码个数
        for (int i = 1; i < maxRange; ++i) {
            count[i] += count[i - 1];
        }

        // 将结果填入 sorted
        for (int i = n - 1; i >= 0; --i) {
            --count[nums[i]];
            // 改进点：将原始电话号码改为了对应的索引，
            //      方便找回排序后的原始电话号码。
            sorted[count[nums[i]]] = i;
        }

        System.arraycopy(sorted, 0, nums, 0, n);
    }
}