package com.google;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        System.out.println(peekingIterator.next());
    }

    @Test
    public void otherTest() {
        System.out.println();
    }
}
