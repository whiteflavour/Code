package com.google.multithread_demo.synchronized_statement;

/**
 * This class uses a synchronized method of grabbing nike shoes.
 * @author Liao, Frank
 * @date 2020.10.31
 */
public class SynchronizedClientMethod implements Runnable {
    private int shoeNumber = 10;

    @Override
    public void run() {
        while (true) {
            grabbingStart();
        }
    }

    /**
     * It is a synchronized method.
     * It is recommended by lecturer Frank.
     */
    public synchronized void grabbingStart() {
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
