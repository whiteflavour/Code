package com.buildappswithpaulo.com;

import com.buildappswithpaulo.com.controller.ScoreBoard;
import com.buildappswithpaulo.com.model.Balloon;
import com.buildappswithpaulo.com.model.Clown;
import com.buildappswithpaulo.com.model.SquareBalloon;

public class Main {

    public static void main(String[] args) {

        ScoreBoard scoreBoard = new ScoreBoard();

        System.out.print("Balloon Tap Score:");
        scoreBoard.algorithmBase = new Balloon();
        scoreBoard.showScore(10, 5);

        System.out.print(" Clown Tap score: ");
        scoreBoard.algorithmBase = new Clown();
        scoreBoard.showScore(10, 5);

        System.out.print("Square Balloon score:");
        scoreBoard.algorithmBase = new SquareBalloon();
        scoreBoard.showScore(10, 5);


    }
}
