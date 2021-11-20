package com.google.leetcode;

import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; ++i) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i - top : i - stack.peek() - 1));
                --i;
            }
        }
        return maxArea;
    }
}