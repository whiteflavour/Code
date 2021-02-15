package com.google.multithread_demo.iteration_test;

public class ITestMain {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {}

        for (int i = 0; i < 1000000; ++i) {}

        long startTime1 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {}
        System.out.println("i++ costs: " + (System.nanoTime() - startTime1) + " nano seconds. ");

        long startTime2 = System.nanoTime();
        for (int i = 0; i < 1000000; ++i) {}
        System.out.println("++i costs: " + (System.nanoTime() - startTime2) + " nano seconds. ");
    }
}
