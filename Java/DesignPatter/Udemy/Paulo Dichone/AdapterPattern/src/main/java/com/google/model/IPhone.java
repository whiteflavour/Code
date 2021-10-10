package com.google.model;

import com.google.interfaces.LightningPhone;

public class IPhone implements LightningPhone {
    private String model;
    private boolean isConnected;

    public IPhone(String model) {
        this.model = model;
    }

    @Override
    public void useLightning() {
        isConnected = true;
        System.out.println("Lightning connected!");
    }

    @Override
    public void recharge() {
        if (isConnected) {
            System.out.println(model + " is recharging using Lighting");
        } else {
            System.out.println("Connect lightning first");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
