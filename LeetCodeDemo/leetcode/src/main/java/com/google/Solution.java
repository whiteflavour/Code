package com.google;

import java.util.*;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left, right;
        left = right = 0;
        while (right <= nums.length)
            if (target > 0) {
                if (right == nums.length) {
                    return ans;
                }
                target -= nums[right];
                ++right;
            } else {
                ans = Math.min(ans, right - left);
                target += nums[left];
                ++left;
            }
        return ans;
    }
}