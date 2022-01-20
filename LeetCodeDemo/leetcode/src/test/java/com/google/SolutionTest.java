package com.google;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(4,8));
    }

    @Test
    public void otherTest() {
        BigInteger n1 = new BigInteger("3487583947589437589237958723892346254776", 10);
        BigInteger n2 = new BigInteger("8767867843568934765983476584376578388", 10);
        BigInteger n = n1.multiply(n2);
        System.out.println(n);
        BigInteger e = BigInteger.valueOf(65537);
        n = n.divide(e);
        System.out.println(n);
        n = n.add(BigInteger.valueOf(1));
        System.out.println(n.multiply(e));
    }
}
