package com.angelagomez.reto7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CommandPatternTest {


    @Test
    void testAdjustVolumeExecute() {
        MusicPlayer player = new MusicPlayer();
        AdjustVolumeCommand command =
                new AdjustVolumeCommand(player, 75, "Angela");

        command.execute();

        assertEquals(75, player.getVolume());
        assertFalse(command.isUndone());
    }

    @Test
    void testAdjustVolumeUndo() {
        MusicPlayer player = new MusicPlayer();
        player.setVolume(20);

        AdjustVolumeCommand command =
                new AdjustVolumeCommand(player, 75, "Angela");

        command.execute();
        command.undo();

        assertEquals(20, player.getVolume());
        assertTrue(command.isUndone());
    }


    @Test
    void testTurnOnLightsExecute() {
        Lights lights = new Lights();
        TurnOnLightsCommand command =
                new TurnOnLightsCommand(lights, "Angela");

        command.execute();

        assertTrue(lights.isLightsOn());
        assertFalse(command.isUndone());
    }

    @Test
    void testTurnOnLightsUndo() {
        Lights lights = new Lights();
        TurnOnLightsCommand command =
                new TurnOnLightsCommand(lights, "Angela");

        command.execute();
        command.undo();

        assertFalse(lights.isLightsOn());
        assertTrue(command.isUndone());
    }


    @Test
    void testPlayMusicExecute() {
        MusicPlayer player = new MusicPlayer();
        PlayMusicCommand command =
                new PlayMusicCommand(player, "Angela");

        command.execute();

        assertTrue(player.isPlaying());
        assertFalse(command.isUndone());
    }

    @Test
    void testPlayMusicUndo() {
        MusicPlayer player = new MusicPlayer();
        PlayMusicCommand command =
                new PlayMusicCommand(player, "Angela");

        command.execute();
        command.undo();

        assertFalse(player.isPlaying());
        assertTrue(command.isUndone());
    }


    @Test
    void testOpenDoorExecute() {
        Door door = new Door();
        OpenDoorCommand command =
                new OpenDoorCommand(door, "Angela");

        command.execute();

        assertFalse(command.isUndone());
    }

    @Test
    void testOpenDoorUndo() {
        Door door = new Door();
        OpenDoorCommand command =
                new OpenDoorCommand(door, "Angela");

        command.execute();
        command.undo();

        assertTrue(command.isUndone());
    }


    @Test
    void testMagicRemoteStoresHistory() {
        MagicRemote remote = new MagicRemote();
        Door door = new Door();

        Command command = new OpenDoorCommand(door, "Angela");

        remote.executeCommand(command);

        assertEquals(1, remote.getHistory().size());
        assertEquals("Angela", remote.getHistory().get(0).getUser());
    }
}
