package com.google.multithread_demo.nike;

public class DaemonThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Daemon thread running ...");
    }
}
