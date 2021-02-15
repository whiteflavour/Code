package com.google.multithread_demo.reentrantlock;

public class RunningReentrantLock {
    public static void main(String[] args) {
        ReentrantLockClassTest reentrantLockClassTest = new ReentrantLockClassTest();
        new Thread(reentrantLockClassTest, "Tom").start();
        new Thread(reentrantLockClassTest, "Dick").start();
        new Thread(reentrantLockClassTest, "Jerry").start();
    }
}
