package com.google.model;

import com.google.interfaces.MicroUsbPhone;

public class LightningToMicroUsbAdapter implements MicroUsbPhone {
    private IPhone iPhone;

    public LightningToMicroUsbAdapter(IPhone iPhone) {
        this.iPhone = iPhone;
    }

    @Override
    public void useMicroUsb() {
        iPhone.useLightning();
        System.out.println("MicroUsb connected!");
    }

    @Override
    public void recharge() {
        System.out.println(iPhone.getModel() + " is recharging using MicroUsb");
    }
}
