package com.google.multithread_demo.Priority;

public class RunPriorityThreads {
    public static void main(String[] args) {
        // run priority threads
        runPriorityThreads();
        // run main thread
        for (int i = 0; i < 3; ++i) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    /**
     * Run priority threads.
     */
    public static void runPriorityThreads() {
        Thread maxThread = new Thread(new MaxPriorityThread());
        Thread minThread = new Thread(new MinPriorityThread());
        maxThread.setPriority(Thread.MAX_PRIORITY);
        minThread.setPriority(Thread.MIN_PRIORITY);
        maxThread.start();
        minThread.start();
        for (int i = 0; i < 30000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
