package com.google;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VisitorPatternTest {
    @Test
    public void testVisitorPattern() {
        Visitor taxVisitor = new TaxVisitor();

        Shirt shirt = new Shirt(45.99);
        TShirt tShirt = new TShirt(129.99);
        Jacket jacket = new Jacket(399.99);

        // Use out tax calculations
        System.out.println(shirt.accept(taxVisitor));
        System.out.println(tShirt.accept(taxVisitor));
        System.out.println(jacket.accept(taxVisitor));
    }
}
