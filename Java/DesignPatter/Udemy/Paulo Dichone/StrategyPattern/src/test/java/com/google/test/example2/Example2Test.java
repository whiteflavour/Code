package com.google.test.example2;

import com.google.example2.CreditCardPayment;
import com.google.example2.PaypalPayment;
import com.google.example2.Product;
import com.google.example2.ShoppingCart;
import org.junit.jupiter.api.Test;

public class Example2Test {
    @Test
    public void testPayment() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product("MacBook pro", 1999));
        shoppingCart.addProduct(new Product("Google Pixel", 999));
        for (Product product : shoppingCart.getProducts()) {
            product.pay(new PaypalPayment());
            // product.pay(new CreditCardPayment());
        }
    }
}
