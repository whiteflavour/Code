package com.google;

public class CEOPurchasePower extends PurchasePower {
    @Override
    protected double getAllowable() {
        return BASE * 100;
    }

    @Override
    protected String getRole() {
        return "CEO";
    }
}
