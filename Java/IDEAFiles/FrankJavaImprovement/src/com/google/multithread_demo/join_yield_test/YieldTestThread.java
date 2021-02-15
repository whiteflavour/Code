package com.google.multithread_demo.join_yield_test;

/**
 * 线程让步
 * @author Frank, Liao
 */
public class YieldTestThread implements Runnable {
    
    @Override
    public void run() {
        for (int i = 0; i < 30; ++i) {
            if (i == 5) {
                System.out.println(Thread.currentThread().getName() + "线程现在开始让步 ...");
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
