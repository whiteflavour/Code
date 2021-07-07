package com.google;

public class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int lengthOfSubNums = 1; lengthOfSubNums <= nums.length; ++lengthOfSubNums) {
            for (int startIndex = 0; startIndex < nums.length; ++startIndex) {
                int sum = 0;
                // 求和
                for (int indexOfNums = startIndex, i = 0; i < lengthOfSubNums && indexOfNums < nums.length; ++indexOfNums, ++i) {
                    sum += nums[indexOfNums];
                }
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}


// 1. 先确定连续子数组的长度，然后遍历 O(n)
// 2. 暴力，O(n²)