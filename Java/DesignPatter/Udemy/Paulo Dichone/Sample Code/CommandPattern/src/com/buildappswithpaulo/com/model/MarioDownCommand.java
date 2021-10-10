package com.buildappswithpaulo.com.model;

import com.buildappswithpaulo.com.interfaces.Command;

public class MarioDownCommand implements Command {
    private MarioCharacterReceiver marioCharacterReceiver;

    public MarioDownCommand(MarioCharacterReceiver marioCharacterReceiver) {
        this.marioCharacterReceiver = marioCharacterReceiver;
    }

    @Override
    public void execute() {
        marioCharacterReceiver.moveDown();

    }
}
