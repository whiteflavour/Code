package com.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main( String[] args ) {
        CEOPurchasePower ceoPurchasePower = new CEOPurchasePower();
        DirectorPurchasePower directorPurchasePower = new DirectorPurchasePower();
        ManagerPurchasePower managerPurchasePower = new ManagerPurchasePower();

        directorPurchasePower.setSuccessor(ceoPurchasePower);
        managerPurchasePower.setSuccessor(directorPurchasePower);

        while (true) {
            System.out.println("Enter the amount to check who should approve to their budget: ");
            System.out.print(">>");

            try {
                double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
                managerPurchasePower.processRequest(new PurchaseRequest(d, "Buy stuff"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
