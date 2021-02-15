package com.google.multithread_demo.frank_notify;

public class RunCondom {
    public static void main(String[] args) {
        Condom condom = new Condom();
        new Thread(new Consumer(condom)).start();
//        new Thread(new Consumer(condom)).start();
        new Thread(new Producer(condom)).start();
    }
}
