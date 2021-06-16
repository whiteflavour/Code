package com.google.with_ioc_container;

public class CounterImpl implements ICounter {
    private int counter;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void resetCounter() {
        counter = 0;
    }

    @Override
    public int getCounter() {
        ++counter;
        return counter;
    }
}
