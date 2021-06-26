package com.google.before_advice;

public class MockTask {
    public void execute(String message) {
        System.out.println("task executing...[" + message + "]");
    }
}
