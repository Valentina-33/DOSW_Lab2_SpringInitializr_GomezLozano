package com.angelagomez.reto7;

public class TurnOnLightsCommand implements Command {

    private Lights lights;
    private boolean previousState;
    private String user;
    private boolean undone = false;

    public TurnOnLightsCommand(Lights lights, String user) {
        this.lights = lights;
        this.user = user;
    }

    @Override
    public void execute() {
        previousState = lights.isLightsOn();
        lights.setLightsState(true);
        undone = false;
        System.out.println("Lights turned on");
    }

    @Override
    public void undo() {
        lights.setLightsState(previousState);
        undone = true;
        System.out.println("Lights turned off (undo)");
    }

    @Override
    public String getDescription() {
        return "Turn on lights";
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
