package com.google.multithread_demo.nike;

/**
 * An anonymous inner class of daemon thread.
 * @author Liao, Frank
 * @date 2020 10.30
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Thread dThread = new Thread(() -> {
            while (true) {
                System.out.println("Inner daemon thread running ...");
            }
        });
        dThread.setDaemon(true);
        dThread.start();
        System.out.println(dThread.isDaemon());

        while (true) {
            System.out.println("Main thread running ...");
        }
    }
}
