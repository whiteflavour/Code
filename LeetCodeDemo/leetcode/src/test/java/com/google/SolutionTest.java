package com.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionTest {
    private StringBuilder sb;

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(26));
    }

    @Test
    public void otherTest() {
        int c = 'A' - 64;
        System.out.println(c);
    }
}
