package com.google.multithread_demo.iteration_test;

import org.junit.Test;

public class ITest {
    @Test
    public void IterationTest1(){
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {}
        System.out.println("i++ costs: " + (System.nanoTime() - startTime) + " nano seconds. ");
    }

    @Test
    public void IterationTest2(){
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; ++i) {}
        System.out.println("++i costs: " + (System.nanoTime() - startTime) + " nano seconds. ");
    }

    @Test
    public void IterationTest() {
        long startTime1 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {}
        System.out.println("i++ costs: " + (System.nanoTime() - startTime1) + " nano seconds. ");

        long startTime2 = System.nanoTime();
        for (int i = 0; i < 1000000; ++i) {}
        System.out.println("++i costs: " + (System.nanoTime() - startTime2) + " nano seconds. ");
    }
}
