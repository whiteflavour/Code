package com.google.multithread_demo.synchronized_statement;

public class RunningLockedClass {
    public static void main(String[] args) {
        AddingALockObject addingALockObject = new AddingALockObject();
        new Thread(addingALockObject, "Tom").start();
        new Thread(addingALockObject, "Dick").start();
        new Thread(addingALockObject, "Jerry").start();
    }
}
