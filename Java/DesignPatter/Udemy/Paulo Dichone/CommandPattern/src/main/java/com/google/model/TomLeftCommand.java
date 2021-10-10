package com.google.model;

import com.google.interfaces.Command;

public class TomLeftCommand implements Command {
    private TomCharacterReceiver tomCharacter;

    public TomLeftCommand(TomCharacterReceiver tomCharacter) {
        this.tomCharacter = tomCharacter;
    }

    @Override
    public void execute() {
        tomCharacter.moveLeft();
    }
}
