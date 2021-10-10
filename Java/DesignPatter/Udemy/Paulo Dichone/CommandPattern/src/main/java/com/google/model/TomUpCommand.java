package com.google.model;

import com.google.interfaces.Command;

public class TomUpCommand implements Command {
    private TomCharacterReceiver tomCharacter;

    public TomUpCommand(TomCharacterReceiver tomCharacter) {
        this.tomCharacter = tomCharacter;
    }

    @Override
    public void execute() {
        tomCharacter.moveUp();
    }
}
