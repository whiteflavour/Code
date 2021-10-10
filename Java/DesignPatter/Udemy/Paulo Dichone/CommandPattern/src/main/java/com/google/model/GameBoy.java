package com.google.model;

import com.google.interfaces.Command;

public class GameBoy {
    private Command upCommand;
    private Command leftCommand;

    public GameBoy(Command upCommand, Command leftCommand) {
        this.upCommand = upCommand;
        this.leftCommand = leftCommand;
    }

    public void arrowUp() {
        upCommand.execute();
    }

    public void arrowLeft() {
        leftCommand.execute();
    }
}
