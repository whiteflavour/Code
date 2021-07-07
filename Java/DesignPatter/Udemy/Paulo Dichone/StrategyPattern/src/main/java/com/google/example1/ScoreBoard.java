package com.google.example1;

public class ScoreBoard {
    private ScoreBoardBase scoreBoardBase;

    public ScoreBoard(ScoreBoardBase scoreBoardBase) {
        this.scoreBoardBase = scoreBoardBase;
    }

    public void showScore() {
        scoreBoardBase.showScore();
    }
}
