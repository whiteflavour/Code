package com.google.multithread_demo.synchronized_statement;

public class AddingALockObject implements Runnable {
    private int shoeNumber = 10;
    Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步代码块
            synchronized (lock) {
                if (shoeNumber > 0) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("恭喜 \"" + Thread.currentThread().getName() + "\" 抢到了第" + (shoeNumber--) + "双鞋");
                }
            }
        }
    }
}
