package com.google.interfaces;

import com.google.model.StateContext;

public interface State {
    void writeName(String name, StateContext context);
}
