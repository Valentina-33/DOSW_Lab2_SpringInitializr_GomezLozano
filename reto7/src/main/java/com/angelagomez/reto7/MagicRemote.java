package com.angelagomez.reto7;

import java.util.ArrayList;
import java.util.List;

public class MagicRemote {

    private List<Command> history = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        history.add(command);
    }

    public void undoCommand(Command command) {
        command.undo();
    }

    public List<Command> getHistory() {
        return history;
    }
}


