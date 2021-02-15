package com.google.multithread_demo.synchronized_statement;

/**
 * An asynchronous class. It has a thread insecurity problem.
 * @author Liao, Frank
 * @date 2020.10.30
 */
public class AsyncGrabbingClient implements Runnable {
    private int shoeNumber = 10;

    @Override
    public void run() {
        while (true) {
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
