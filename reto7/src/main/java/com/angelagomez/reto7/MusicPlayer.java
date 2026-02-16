package com.angelagomez.reto7;

public class MusicPlayer {

    private int volume;
    private boolean isPlaying; 

    public MusicPlayer() {
        this.volume = 0; 
        this.isPlaying = false; 

    }

    public boolean isPlaying() { return this.isPlaying; }

    public void setPlayingState(boolean state ){ this.isPlaying = state; }

    public int getVolume () { return this.volume; }

    public void setVolume (int vol) { this.volume = vol; }

}
