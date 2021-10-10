package com.buildappswithpaulo.com.model;

import com.buildappswithpaulo.com.interfaces.Command;

public class MarioLeftCommand implements Command {

    private MarioCharacterReceiver marioCharacter;

    public MarioLeftCommand(MarioCharacterReceiver marioCharacter) {
        this.marioCharacter = marioCharacter;
    }

    @Override
    public void execute() {
        marioCharacter.moveLeft();

    }
}
