package com.google.multithread_demo.my_notify;

/**
 * Running the threads.
 * @author Liao, Frank
 * @date 2020-11-16
 */
public class RunCondom {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ThreadCreating();
    }

    /**
     * Create two threads that one presents consumer and the other presents producer.
     */
    public static void ThreadCreating() {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        Thread conThread = new Thread(consumer);
        Thread proThread = new Thread(producer);
        conThread.start();
        proThread.start();
    }
}
