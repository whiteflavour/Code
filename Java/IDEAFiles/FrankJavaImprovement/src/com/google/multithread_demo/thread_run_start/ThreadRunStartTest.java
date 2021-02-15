package com.google.multithread_demo.thread_run_start;

public class ThreadRunStartTest extends Thread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread, "My 1st thread ...").start();

        while (true) {
            System.out.println("main thread running ...");
        }
    }
}
