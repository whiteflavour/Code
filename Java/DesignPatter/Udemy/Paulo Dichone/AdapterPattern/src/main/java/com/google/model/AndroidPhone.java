package com.google.model;

import com.google.interfaces.MicroUsbPhone;

public class AndroidPhone implements MicroUsbPhone {
    private String model;
    private boolean isConnected;

    public AndroidPhone(String model) {
        this.model = model;
    }

    @Override
    public void useMicroUsb() {
        isConnected = true;
        System.out.println("MicroUsb connected!");
    }

    @Override
    public void recharge() {
        if (isConnected) {
            System.out.println(model + " is recharging using MicroUsb");
        } else {
            System.out.println("Connect MicroUsb first");
        }
    }
}
