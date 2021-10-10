package com.buildappswithpaulo.com.model;

import com.buildappswithpaulo.com.interfaces.Command;

public class KirbyLeftCommand implements Command{
    private KirbyCharacterReceiver kirbyCharacterReceiver;

    public KirbyLeftCommand(KirbyCharacterReceiver kirbyCharacterReceiver) {
        this.kirbyCharacterReceiver = kirbyCharacterReceiver;
    }

    @Override
    public void execute() {
        kirbyCharacterReceiver.moveLeft();
    }
}
