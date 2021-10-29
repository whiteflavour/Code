package com.google;

import com.google.model.StateContext;
import org.junit.jupiter.api.Test;

public class StatePatternTest {
    @Test
    public void testStatePattern() {
        StateContext context = new StateContext();
        context.writeName("Monday");
        context.writeName("Tuesday");
        context.writeName("Wednesday");
        context.writeName("Thursday");
        context.writeName("Friday");
        context.writeName("Saturday");
        context.writeName("Sunday");
    }
}
