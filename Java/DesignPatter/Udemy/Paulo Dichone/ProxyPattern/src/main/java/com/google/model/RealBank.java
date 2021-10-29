package com.google.model;

import com.google.interfaces.Bank;

public class RealBank implements Bank {
    @Override
    public void withdrawMoney() {
        System.out.println("Withdraw money from real bank...");
    }
}
