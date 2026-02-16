package com.angelagomez.reto7;

public class AdjustVolumeCommand implements Command {

    private MusicPlayer musicPlayer;
    private int volume;
    private int previousVolume;
    private String user;
    private boolean undone = false; 

    public AdjustVolumeCommand(MusicPlayer musicPlayer, int volume, String user) {
        this.musicPlayer = musicPlayer;
        this.volume = volume;
        this.user = user;
    }

    @Override
    public void execute() {
        previousVolume = musicPlayer.getVolume();
        musicPlayer.setVolume(volume);
        undone = false;

    }

    @Override
    public void undo() {
        musicPlayer.setVolume(previousVolume);
        undone = true;

    }

    @Override
    public String getDescription() {
        return "Ajustar volumen a " + volume + "%";
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
