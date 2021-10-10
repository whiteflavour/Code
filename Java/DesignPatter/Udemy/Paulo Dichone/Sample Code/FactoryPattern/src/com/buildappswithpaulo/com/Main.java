package com.buildappswithpaulo.com;

import com.buildappswithpaulo.com.interfaces.HamburgerStore;
import com.buildappswithpaulo.com.model.CheeseBurger;
import com.buildappswithpaulo.com.model.Hamburger;
import com.buildappswithpaulo.com.model.JamHamburgerstore;
import com.buildappswithpaulo.com.model.MozHamburgerStore;

public class Main {

    public static void main(String[] args) {

        CheeseBurger cheeseBurger = new CheeseBurger();

        HamburgerStore mozambicanBurgerStore = new MozHamburgerStore();
        HamburgerStore jamaicanBurgerStore = new JamHamburgerstore();

        Hamburger hamburger = mozambicanBurgerStore.orderHamburger("cheese");
        System.out.println("Paulo ordered " + hamburger.getName() + "\n" );


        hamburger = jamaicanBurgerStore.orderHamburger("veggie");
        System.out.println("James Bond ordered: " + hamburger.getName() + "\n");




    }
}
