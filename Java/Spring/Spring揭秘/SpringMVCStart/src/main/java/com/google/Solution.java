package com.google;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        backtrack(nums, ans, combine, new boolean[nums.length]);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> combine, boolean[] used) {
        if (combine.size() == nums.length) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            combine.add(nums[i]);
            backtrack(nums, ans, combine, used);
            used[i] = false;
            combine.remove(combine.size() - 1);
        }
    }
}