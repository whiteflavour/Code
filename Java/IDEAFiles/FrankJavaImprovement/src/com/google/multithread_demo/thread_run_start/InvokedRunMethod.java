package com.google.multithread_demo.thread_run_start;

public class InvokedRunMethod {
    public static void main(String[] args) {
        OnlyInvokedRunMethod runMethod = new OnlyInvokedRunMethod();
        // Invoking run method, and because of the "while (true)" statement, the behind statements will not work.
        runMethod.run();

        // This block will not work.
        while (true) {
            System.out.println("Main thread running ...");
        }
    }
}
