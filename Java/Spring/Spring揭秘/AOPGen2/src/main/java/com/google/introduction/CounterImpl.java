package com.google.introduction;

public class CounterImpl implements ICounter {
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return ++count;
    }
}
