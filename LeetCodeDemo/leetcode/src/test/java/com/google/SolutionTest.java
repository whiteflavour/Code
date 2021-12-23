package com.google;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

public class SolutionTest {
    private Map<BigInteger, BigInteger> cache = new HashMap<>();

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(26));
    }

    @Test
    public void otherTest() {
        System.out.println(partition(1, 5469));
        System.out.println(factorial(BigInteger.valueOf(5469)));
    }

    /**
     * Use divide and conquer to calculate the factorial of n (n!)
     * <b>Note:</b> We use <i>BigInteger</i> to avoid overflow.
     *
     * @param left first number to be multiplied (always be 1)
     * @param right last number to be multiplied (e.g. if we need
     *              to calculate n!, then <i>left</i> is 1 and
     *              <i>right</i> is n)
     * @return the result
     */
    public BigInteger partition(int left, int right) {
        if (left >= right) {
            return BigInteger.valueOf(left == right ? left : 1);
        }
        int mid = left + (right - left >> 1);
        if (left + 1 == right) {
            return BigInteger.valueOf((long) left * right);
        }
        BigInteger leftProduct = partition(left, mid);
        BigInteger rightProduct = partition(mid + 1, right);
        return leftProduct.multiply(rightProduct);
    }

    public BigInteger factorial(BigInteger n) {
        return n.equals(BigInteger.valueOf(0)) ? BigInteger.valueOf(1) : n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }
}
