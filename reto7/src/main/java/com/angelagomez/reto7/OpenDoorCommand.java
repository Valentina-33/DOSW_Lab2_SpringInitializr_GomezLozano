package com.angelagomez.reto7;

public class OpenDoorCommand implements Command {

    private final Door door;
    private final String user;
    private boolean undone = false;

    public OpenDoorCommand(Door door, String user) {
        this.door = door;
        this.user = user;
    }

    @Override
    public void execute() {
        door.open();
        undone = false;
        System.out.println("Opened door");
    }

    @Override
    public void undo() {
        door.close();
        undone = true;
        System.out.println("opened closed (undo)");
    }

    @Override
    public String getDescription() {
        return "Open door";
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public boolean isUndone() {
        return undone;
    }
}
