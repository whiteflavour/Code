package com.google.multithread_demo.thread_run_start;

public class OnlyInvokedRunMethod extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("A running thread ...");
        }
    }
}
