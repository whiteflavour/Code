package com.buildappswithpaulo.com.model;

import com.buildappswithpaulo.com.controller.ScoreAlgorithmBase;

public class Clown extends ScoreAlgorithmBase {
    @Override
    public int calculateScore(int taps, int multiplier) {
         return (taps * multiplier) - 10;
    }
}
