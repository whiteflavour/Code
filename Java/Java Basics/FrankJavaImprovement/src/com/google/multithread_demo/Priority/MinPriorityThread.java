package com.google.multithread_demo.Priority;

public class MinPriorityThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 30000; ++i) {
            System.out.println("Min priority thread ...");
        }
    }
}
