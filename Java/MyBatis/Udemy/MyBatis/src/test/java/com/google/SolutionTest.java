package com.google;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.isValid("[({(())}[()])]"));
    }
}
