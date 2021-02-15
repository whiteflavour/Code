package com.google.multithread_demo.synchronized_statement;

public class RunningAsyncClient {
    public static void main(String[] args) {
        AsyncGrabbingClient asyncGrabbingClient = new AsyncGrabbingClient();
        new Thread(asyncGrabbingClient, "Tom").start();
        new Thread(asyncGrabbingClient, "Dick").start();
        new Thread(asyncGrabbingClient, "Jerry").start();
    }
}
