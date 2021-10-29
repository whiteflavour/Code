package com.google.model;

import com.google.interfaces.State;

public class MultipleUpperCaseState implements State {
    private int counter = 0;

    @Override
    public void writeName(String name, StateContext context) {
        System.out.println(name.toUpperCase());
        if (++counter > 1) {
            context.setState(new LowerCaseState());
        }
    }
}
