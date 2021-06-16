package com.google.advice;

public class Tester implements ITester {
    private boolean busyAsTester;

    public void setBusyAsTester(boolean busyAsTester) {
        this.busyAsTester = busyAsTester;
    }

    @Override
    public boolean isBusyAsTester() {
        return busyAsTester;
    }

    @Override
    public void testSoftware() {
        System.out.println("testing ... ");
    }
}
