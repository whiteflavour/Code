package com.google.multithread_demo.frank_notify;

/**
 * Frank's Consumer to grab condoms.
 * @author Frank, Liao
 * @date 2020-11-16
 */
public class Consumer extends Thread {
    /**
     * 方便传入同一个对象，作为对象锁。
     */
    private Condom condom;

    /**
     * 如果没有该构造，run 方法可能只执行一次。————Frank （To do）
     * @param condom
     */
    public Consumer(Condom condom) {
        this.condom = condom;
    }

    @Override
    public void run() {
        while (true) {
            // 对象锁
            synchronized (condom) {
                if (condom.isHaving == false) {
                    try {
                        // 套没了，消费者死等，消费者线程等待。
                        condom.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 套没了，提醒生产者赶紧生产，唤醒生产者线程。
                condom.isHaving = false;
                System.out.println(Thread.currentThread().getName() + " There are no condoms, please hurry to produce them, I'll let my girls can't go out of bed!!");
                condom.notify();
            }
        }
    }
}
