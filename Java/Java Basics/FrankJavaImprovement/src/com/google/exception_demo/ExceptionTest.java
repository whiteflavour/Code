package com.google.exception_demo;

import org.junit.Test;

public class ExceptionTest {
    @Test
    public void Test() throws LxyException, FrankException {
//        System.out.println(sum(6, 8));
        System.out.println(frankExceptionSum(6, 8));
    }

    public int sum(int numberA, int numberB) throws LxyException {
        if (numberA > 5) {
            throw new LxyException(LxyExceptionEnum.TOO_BIG_NUMBER);
        }
        return numberA + numberB;
    }

    public int frankExceptionSum(int numberA, int numberB) throws FrankException {
        if (numberA > 5) {
            throw new FrankException(LxyExceptionEnum.TOO_BIG_NUMBER);
        }
        return numberA + numberB;
    }
}
