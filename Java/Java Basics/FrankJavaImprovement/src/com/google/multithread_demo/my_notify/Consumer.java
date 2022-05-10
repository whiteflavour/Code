package com.google.multithread_demo.my_notify;

/**
 * The consumer that buys condoms.
 * @author Liao, Frank
 * @date 2020-11-16
 */
public class Consumer implements Runnable {
    Condom condom = new Condom();

    public Consumer() {}

    @Override
    public void run() {
        while (true) {
            synchronized (condom) {
                if (condom.getHaving() == true) {
                    condom.notify();
                }
                if (condom.getHaving() == false) {
                    try {
                        System.out.println("There are no condoms, please hurry to produce, I'll let my girl can't go out of my bed!! Waiting for you!!");
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    condom.setHaving(true);
                }
            }
        }
    }
}
