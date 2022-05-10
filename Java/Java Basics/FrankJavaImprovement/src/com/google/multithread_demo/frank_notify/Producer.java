package com.google.multithread_demo.frank_notify;

/**
 * Frank's producer that produces condoms.
 * @author Frank, Liao
 * @date 2020-11-17
 */
public class Producer extends Thread {
    // 便于传入同一个对象。
    private Condom condom;

    /**
     * 若无此构造，run 方法中的内容可能只会执行一次。————Frank
     */
    public Producer(Condom condom) {
        this.condom = condom;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (condom) {
                if (condom.isHaving == true) {
                    try {
                        // 如果还有套，生产者线程等待。
                        condom.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condom.isHaving = true;
                System.out.println(Thread.currentThread().getName() + " We've produced so many condoms, enjoy yourself, and make her sexy!! Just fuck her!!");
                // 还有套，提醒消费者赶快买，唤醒消费者线程。
                condom.notifyAll();
            }
        }
    }
}
