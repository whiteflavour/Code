package com.google.multithread_demo.synchronized_and_Lock_test;

public class RunningThePerformanceTest {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        SynchronizeAndLockPerformanceTest.lockTest();
        SynchronizeAndLockPerformanceTest.synTest();
    }
}
