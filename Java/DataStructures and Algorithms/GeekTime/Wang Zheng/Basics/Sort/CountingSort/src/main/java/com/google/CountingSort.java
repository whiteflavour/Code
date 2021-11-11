package com.google;

/**
 * 给 0-5 分的考生排序
 *
 * @author Liao
 * @date 2021-11-10
 */
public class CountingSort {
    public void countingSort(int[] nums) {
        int n = nums.length;
        // 根据分数的范围来确定的数组的长度
        int maxRange = 6;
        // 记录分数小于等于该数组下标的人数
        int[] count = new int[maxRange];
        // 存储已经排好序的结果
        int[] sorted = new int[n];

        // 计算每个分数对应的人数
        for (int num : nums) {
            ++count[num];
        }
        // 将人数进行累加
        for (int i = 1; i < maxRange; ++i) {
            count[i] += count[i - 1];
        }
        // 反向遍历 nums[]（保证排序的稳定性），将对应的分数
        // 填入 sorted[对应人数 - 1] 处。
        for (int i = n - 1; i >= 0; --i) {
            --count[nums[i]];
            sorted[count[nums[i]]] = nums[i];
        }
        System.arraycopy(sorted, 0, nums, 0, n);
    }
}
