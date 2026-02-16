package com.angelagomez.reto7;

public class Lights {

    private boolean lightsOn;

    public Lights() {
        this.lightsOn = false; 
    }

    public boolean isLightsOn() { return lightsOn; }

    public void setLightsState(boolean state) { this.lightsOn = state; }
}
