package com.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionTest {
    private StringBuilder sb;

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {2,2,1,4,1,2,2}));
    }

    @Test
    public void otherTest() {
        char c = 1 + 64;
        char ch = 'A' + 25;
        System.out.println(ch);
    }
}
