package com.google.junit;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class DemoTest {
    @Test
    public void sum() {
        int numberA = ThreadLocalRandom.current().nextInt(0,10);
        int numberB = ThreadLocalRandom.current().nextInt(0,10);
        int sum = Demo.sum(numberA, numberB);
        Assert.assertEquals(numberA + numberB, sum);
    }

    @Test
    public void subtract() {
        int numberA = ThreadLocalRandom.current().nextInt(0,10);
        int numberB = ThreadLocalRandom.current().nextInt(0,10);
        int subtract = Demo.subtract(numberA, numberB);
        Assert.assertEquals(numberA - numberB, subtract);
    }
}
