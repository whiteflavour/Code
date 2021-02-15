package com.google.multithread_demo.join_yield_test;

/**
 * 线程插队测试
 * @author Liao, Frank
 * @date 2020-11-1
 */
public class JoinMain {
    private static Thread aThread = new Thread(() -> {
        for (int i = 0; i < 3; ++i) {
            System.out.println("a thread ...");
        }
    });

    public static void main(String[] args) {
        // 开启 main
        joinMain();
    }

    public static void joinMain() {
        // 线程插队
        aThread.start();
        // main
        for (int i = 0; i < 6; ++i) {
            if (i == 2) {
                try {
                    aThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
