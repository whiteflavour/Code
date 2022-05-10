package com.google.multithread_demo.runnable;

public class RunnableTest {
    public static void main(String[] args) {
        MyRunnableThread myRunnableThread = new MyRunnableThread();
        Thread thread = new Thread(myRunnableThread);
        thread.start();

        while (true) {
            System.out.println("main thread running ...");
        }
    }
}
