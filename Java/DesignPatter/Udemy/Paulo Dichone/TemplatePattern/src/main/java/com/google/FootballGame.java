package com.google;

public class FootballGame extends Game {
    @Override
    void initialize() {
        System.out.println("Initializing football game...");
    }

    @Override
    void startPlay() {
        System.out.println("Starting football game ...");
    }

    @Override
    void endPlay() {
        System.out.println("Ending football game...");
    }
}
