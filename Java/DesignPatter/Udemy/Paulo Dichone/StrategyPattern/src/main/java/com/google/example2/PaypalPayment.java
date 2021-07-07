package com.google.example2;

public class PaypalPayment implements Payment {
    @Override
    public void pay(String name, double amount) {
        System.out.println("paid with paypal: " + name + ", " + amount + "$");
    }
}
