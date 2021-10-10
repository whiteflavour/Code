package com.google;

import com.google.interfaces.Command;
import com.google.model.*;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    public void testCommandPattern() {
        MarioCharacterReceiver mario = new MarioCharacterReceiver("Mario");
        Command marioUpCommand = new MarioUpCommand(mario);
        Command marioLeftCommand = new MarioLeftCommand(mario);
        GameBoy gameBoy = new GameBoy(marioUpCommand, marioLeftCommand);
        gameBoy.arrowUp();

        TomCharacterReceiver tom = new TomCharacterReceiver("Tom");
        Command tomUpCommand = new TomUpCommand(tom);
        Command tomLeftCommand = new TomLeftCommand(tom);
        GameBoy gameBoy2 = new GameBoy(tomUpCommand, tomLeftCommand);
        gameBoy2.arrowLeft();
    }
}
