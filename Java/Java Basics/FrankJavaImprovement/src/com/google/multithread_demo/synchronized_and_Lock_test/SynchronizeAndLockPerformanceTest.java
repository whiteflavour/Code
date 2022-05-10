package com.google.multithread_demo.synchronized_and_Lock_test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * An uncompleted class.
 *
 * @author Liao
 * @date 2020-10-31
 */
public class SynchronizeAndLockPerformanceTest {
    private static int aNumber = 0;
    private static long startTime = 0;
    private static long endTime = 0;
    private static int threadsNumber = 10;

    /**
     * Synchronized block test.
     */
    public static void synTest() {
        Object lock = new Object();
        Thread[] threads = new Thread[threadsNumber];
        // let every thread in threads to add the "aNumber"
        for (int i = 0; i < threadsNumber; ++i) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000000; ++j) {
                    synchronized (lock) {
                        ++aNumber;
                    }
                }
            });
        }
        startTime = System.nanoTime();
        // run these threads
        for (int i = 0; i < threadsNumber; ++i) {
            threads[i].start();
        }
        // waiting for these threads to die
        for (int i = 0; i < threadsNumber; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        endTime = System.nanoTime();
        System.out.println("The cost of synchronized method in nano seconds: " + (endTime - startTime));
    }

    /**
     * Test the lock object.
     */
    public static void lockTest() {
        Thread[] threads = new Thread[threadsNumber];
        Lock reentrantLock = new ReentrantLock();
        // let every thread in threads to add the "aNumber"
        for (int i = 0; i < threadsNumber; ++i) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000000; ++j) {
                    reentrantLock.lock();
                    try {
                        ++aNumber;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            });
        }
        startTime = System.nanoTime();
        // run these threads
        for (int i = 0; i < threadsNumber; ++i) {
            threads[i].start();
        }
        // waiting for these threads to die
        for (int i = 0; i < threadsNumber; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        endTime = System.nanoTime();
        System.out.println("The cost of the Lock class in nano seconds: " + (endTime - startTime));
    }
}
