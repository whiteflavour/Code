package com.google;

public abstract class Vehicle {
    protected WorkShop workShop;
    protected WorkShop workShop2;

    public Vehicle(WorkShop workShop, WorkShop workShop2) {
        this.workShop = workShop;
        this.workShop2 = workShop2;
    }

    abstract public void manufacture();
}
