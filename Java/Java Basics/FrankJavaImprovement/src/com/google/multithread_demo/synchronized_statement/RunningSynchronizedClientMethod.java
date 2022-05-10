package com.google.multithread_demo.synchronized_statement;

public class RunningSynchronizedClientMethod {
    public static void main(String[] args) {
        SynchronizedClientMethod synchronizedClientMethod = new SynchronizedClientMethod();
        new Thread(synchronizedClientMethod, "Dick").start();
        new Thread(synchronizedClientMethod, "Tom").start();
        new Thread(synchronizedClientMethod, "Jerry").start();
    }
}
