package com.google.after_advice.after_finally;

public class FinallyClass {
    public void finallyGotShit() {
        try {
            System.out.println("in try block ...");
        } finally {
            System.out.println("in finally block ... I finally got shit ... ");
        }
    }
}
