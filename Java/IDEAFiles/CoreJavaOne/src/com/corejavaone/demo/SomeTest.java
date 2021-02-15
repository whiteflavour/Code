package com.corejavaone.demo;

import org.junit.Test;

public class SomeTest {
    @Test
    public void demo() throws Exception {
        sum(11, 2);
    }

    public int sum(int a, int b) throws Exception {
        if (a > 10) {
            throw new Exception();
        }
        return a + b;
    }
}
