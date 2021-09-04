package com.google.test;

import com.google.leetcode.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
