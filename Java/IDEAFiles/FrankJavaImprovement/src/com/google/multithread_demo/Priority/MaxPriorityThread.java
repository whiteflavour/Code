package com.google.multithread_demo.Priority;

public class MaxPriorityThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 30000; ++i) {
            System.out.println("Max priority thread ...");
        }
    }
}
