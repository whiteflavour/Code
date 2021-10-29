package com.google.model;

import com.google.interfaces.Bank;

public class ProxyBank implements Bank {
    private Bank bank;

    public ProxyBank() {
        bank = new RealBank();
    }

    @Override
    public void withdrawMoney() {
        System.out.println("Withdraw money from ATM...");
        bank.withdrawMoney();
    }
}
