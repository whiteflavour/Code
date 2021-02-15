package com.google.multithread_demo.thread_run_start;

public class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("My Thread running ..." + Thread.currentThread().getName());
        }
    }
}
