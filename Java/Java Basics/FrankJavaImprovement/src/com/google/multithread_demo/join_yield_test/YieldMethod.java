package com.google.multithread_demo.join_yield_test;

/**
 * 线程让步
 * @author Frank, Liao
 */
public class YieldMethod {
    public static void main(String[] args) {
        runYield();
    }

    public static void runYield() {
        YieldTestThread yieldTestThread = new YieldTestThread();
        Thread thread1 = new Thread(yieldTestThread);
        Thread thread2 = new Thread(yieldTestThread);
        thread1.start();
        thread2.start();
    }
}