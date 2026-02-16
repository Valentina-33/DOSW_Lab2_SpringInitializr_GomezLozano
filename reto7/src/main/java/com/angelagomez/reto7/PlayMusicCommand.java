package com.angelagomez.reto7;

public class PlayMusicCommand implements Command {

    private MusicPlayer musicPlayer;
    private boolean previousState;
    private final String user;
    private boolean undone = false;

    public PlayMusicCommand(MusicPlayer musicPlayer, String user) {
        this.musicPlayer = musicPlayer;
        this.user = user;
    }

    @Override
    public void execute() {
        previousState = musicPlayer.isPlaying();
        musicPlayer.setPlayingState(true);
        undone = false;
        System.out.println("Music started");
    }

    @Override
    public void undo() {
        musicPlayer.setPlayingState(previousState);
        undone = true;
        System.out.println("Music stopped (undo)");
    }

    @Override
    public String getDescription() {
        return "Play music";
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
