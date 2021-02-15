package com.google.multithread_demo.my_notify;

/**
 * The producer that produces condoms.
 * @author Liao, Frank
 * @date 2020-11-16
 */
public class Producer implements Runnable {
    Condom condom = new Condom();

    public Producer() {}

    @Override
    public void run() {
        while (true) {
            synchronized (condom) {
                if (condom.getHaving() == false) {
                    condom.notify();
                }
                if (condom.getHaving() == true) {
                    try {
                        Thread.currentThread().wait();
                        System.out.println("We've produced a huge number of condoms, please buy as many as you can!! Make your girl sexy!! Just buy them!!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    condom.setHaving(false);
                }
            }
        }
    }
}
