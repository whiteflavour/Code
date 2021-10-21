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
        System.out.println(solution.canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
    }

    @Test
    public void otherTest() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, null, 1));
        System.out.println(list1.equals(list2));
    }
}
