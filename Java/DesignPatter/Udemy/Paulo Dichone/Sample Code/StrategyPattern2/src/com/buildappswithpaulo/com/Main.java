package com.buildappswithpaulo.com;

import com.buildappswithpaulo.com.controller.CreditCardAlgorithm;
import com.buildappswithpaulo.com.controller.PaypalAlgorithm;
import com.buildappswithpaulo.com.controller.ShoppingCart;
import com.buildappswithpaulo.com.model.Product;

public class Main {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Product pants = new Product("234", 25);
        Product shirt = new Product("987", 15);


        cart.addProduct(pants);
        cart.addProduct(shirt);


        //payment decisions
        cart.pay(new PaypalAlgorithm("paulo@buildappswithpaulo.com", "nowayman"));


        cart.pay(new CreditCardAlgorithm("Paulo", "238756464"));


    }
}
