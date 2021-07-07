package com.google.test.example1;

import com.google.example1.Balloon;
import com.google.example1.Clown;
import com.google.example1.ScoreBoard;
import com.google.example1.SquareBalloon;
import org.junit.jupiter.api.Test;

public class Example1Test {
    @Test
    public void testScore() {
        ScoreBoard score;
        score = new ScoreBoard(new Balloon());
        score.showScore();
        score = new ScoreBoard(new Clown());
        score.showScore();
        score = new ScoreBoard(new SquareBalloon());
        score.showScore();
    }
}
