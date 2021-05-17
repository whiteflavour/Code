package com.google.test;

import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTestDemo {
    @Test
    public void addTest() {
        int num1 = 3;
        int num2 = 8;

        int sum = num1 + num2;

        assertEquals(8, sum);
    }
}
