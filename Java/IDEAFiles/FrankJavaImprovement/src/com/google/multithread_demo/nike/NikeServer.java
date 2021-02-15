package com.google.multithread_demo.nike;

public class NikeServer {
    public static void main(String[] args) {
        // 后台线程 ————守护线程
        Thread dThread = new Thread(new DaemonThread());
        dThread.setDaemon(true);
        dThread.start();
        System.out.println(dThread.isAlive());

        // 前台线程
        GrabbingClient grabbingClient = new GrabbingClient();
        new Thread(grabbingClient, "Tom").start();
        new Thread(grabbingClient, "Dick").start();
        new Thread(grabbingClient, "Jerry").start();
        new Thread(grabbingClient, "Kevin").start();
    }
}
