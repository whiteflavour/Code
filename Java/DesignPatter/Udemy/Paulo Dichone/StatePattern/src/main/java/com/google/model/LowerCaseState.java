package com.google.model;

import com.google.interfaces.State;

public class LowerCaseState implements State {
    @Override
    public void writeName(String name, StateContext context) {
        System.out.println(name.toLowerCase());
        context.setState(new MultipleUpperCaseState());
    }
}
