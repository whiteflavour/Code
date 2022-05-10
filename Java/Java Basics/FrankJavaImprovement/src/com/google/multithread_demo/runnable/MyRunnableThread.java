package com.google.multithread_demo.runnable;

public class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("My runnable thread running ...");
        }
    }
}
