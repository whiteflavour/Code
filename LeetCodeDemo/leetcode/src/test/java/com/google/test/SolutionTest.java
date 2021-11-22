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
        System.out.println(solution.maximalRectangle(new char[][]{{'1','1','1','1','1'}, {'1','1','1','1','1'}, {'1','1','1','1','1'}, {'1','1','1','1','1'}, {'1','1','1','1','1'},{'1','1','1','1','1'}, {'1','1','1','1','1'}, {'1','1','1','1','1'}, {'1','1','1','1','1'}, {'1','1','1','1','1'}}));
    }

    @Test
    public void otherTest() {
        char c1 = '1';
        char c2 = '2';
        int c = c1;
        System.out.println(c);
        System.out.println((char)(c1 + 1));
        System.out.println(Character.digit(c2, 10) * 2);
    }
}
