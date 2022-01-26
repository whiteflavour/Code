package com.google;

import org.junit.jupiter.api.Test;

public class MediatorPatternTest {
    @Test
    public void testMediatorPattern() {
        ATCMediator mediator = new ATCMediatorImpl();

        // Create few aircraft
        AirCraft boing1 = new AirCraftImpl(mediator, "Boing 1");
        AirCraft helicopter = new AirCraftImpl(mediator, "Helicopter");
        AirCraft boing707 = new AirCraftImpl(mediator, "Boing 707");

        // Adding aircraft to the mediator
        mediator.addAirCraft(boing1);
        // mediator.addAirCraft(helicopter);
        mediator.addAirCraft(boing707);

        boing1.send("Hello from Boing 1");
    }
}
