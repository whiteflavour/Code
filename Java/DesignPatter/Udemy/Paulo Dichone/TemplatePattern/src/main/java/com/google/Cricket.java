package com.google;

public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Initializing cricket game...");
    }

    @Override
    void startPlay() {
        System.out.println("Starting cricket game ...");
    }

    @Override
    void endPlay() {
        System.out.println("Ending cricket game...");
    }
}
