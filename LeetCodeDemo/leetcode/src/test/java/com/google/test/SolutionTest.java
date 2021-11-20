package com.google.test;

import com.google.leetcode.Solution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,2}));
    }

    @Test
    public void otherTest() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append("   ").append(", world")
                .append("  ");
        System.out.println(sb.toString().trim());
    }
}
