package com.google;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testGame() {
        Game football = new FootballGame();
        football.play();
        System.out.println();
        Game cricket = new Cricket();
        cricket.play();
    }
}
