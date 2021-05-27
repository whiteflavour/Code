package com.google.factory_method;

public class NextDay {
    private int nextDay;

    public NextDay() {
    }

    public int getNextDay() {
        return nextDay;
    }

    public void setNextDay(int nextDay) {
        this.nextDay = nextDay;
    }

    public void showNextDay() {
        System.out.println(nextDay);
    }
}
