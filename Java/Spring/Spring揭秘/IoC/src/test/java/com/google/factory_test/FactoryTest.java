package com.google.factory_test;

import com.google.factory_method.Alien;
import org.junit.Test;

public class FactoryTest {
    @Test
    public void AlienTest() {
        Alien alien = new Alien();
        alien.code();
    }
}
