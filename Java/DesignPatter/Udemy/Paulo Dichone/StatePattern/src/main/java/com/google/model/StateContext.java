package com.google.model;

import com.google.interfaces.State;

public class StateContext {
    private State state;

    public StateContext() {
        state = new LowerCaseState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void writeName(String name) {
        state.writeName(name, this);
    }
}
