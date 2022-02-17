package com.google;

import java.util.*;

public class Solution {
    private static final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(new ArrayList<>(), k, n, 0);
        return ans;
    }

    public void backtrack(List<Integer> combine, int k, int n, int start) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        if (k == 0 || n < 0) {
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            if (!combine.isEmpty() && nums[i] < combine.get(combine.size() - 1)){
                continue;
            }
            combine.add(nums[i]);
            backtrack(combine, k - 1, n - nums[i], start + 1);
            combine.remove(combine.size() - 1);
        }
    }
}