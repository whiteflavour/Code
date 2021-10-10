package com.google.leetcode;

import java.util.*;

public class Solution {
    private Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.get(0).size()];
        return dfs(triangle, 0, 0);
    }

    public int dfs(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        return memo[row][col] = Math.min(dfs(triangle, row + 1, col), dfs(triangle, row + 1, col + 1)) + triangle.get(row).get(col);
    }
}