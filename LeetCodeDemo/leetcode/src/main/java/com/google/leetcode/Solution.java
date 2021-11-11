package com.google.leetcode;

import java.util.*;

public class Solution {
    private Deque<String> ans;

    public String getPermutation(int n, int k) {
        ans = new LinkedList<>();
        backtrack(new StringBuilder(), n, 0, k);
        return ans.getLast();
    }

    private void backtrack(StringBuilder path, int n, int start, int k) {
        if (ans.size() >= k) {
            return;
        }
        if (path.length() == n) {
            ans.add(String.valueOf(path));
            return;
        }
        for (int i = 0; i < n; ++i) {
            boolean hasValue = false;
            for (int j = 0; j < path.length(); ++j) {
                if (Character.digit(path.charAt(j), 10) == i + 1) {
                    hasValue = true;
                    break;
                }
            }
            if (hasValue) {
                continue;
            }
            path.append(i + 1);
            backtrack(path, n, start + 1, k);
            path.deleteCharAt(path.length() - 1);
        }
    }
}