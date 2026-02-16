package com.angelagomez.reto7;

public interface Command {
    void execute();
    void undo();
    String getDescription();
    String getUser();
    boolean isUndone();
}




