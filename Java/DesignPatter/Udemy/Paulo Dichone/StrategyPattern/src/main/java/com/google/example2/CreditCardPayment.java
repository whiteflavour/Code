package com.google.example2;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(String name, double amount) {
        System.out.println("paid with credit card: " + name + ", " + amount + "$");
    }
}
