package com.angelagomez.reto7;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MagicRemote remote = new MagicRemote();
        Door door = new Door();
        Lights lights = new Lights();
        MusicPlayer musicPlayer = new MusicPlayer();

        System.out.print("Number of actions to register: ");
        int numberOfActions = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfActions; i++) {

            System.out.println("\nAction " + i + ":");

            System.out.print("User: ");
            String user = scanner.nextLine();

            System.out.println("""
                    Select an option:
                    1. Turn on lights
                    2. Open door
                    3. Play music
                    4. Adjust volume
                    """);

            int option = scanner.nextInt();
            scanner.nextLine();

            Command command = null;

            switch (option) {

                case 1:
                    command = new TurnOnLightsCommand(lights, user);
                    break;

                case 2:
                    command = new OpenDoorCommand(door, user);
                    break;

                case 3:
                    command = new PlayMusicCommand(musicPlayer, user);
                    break;

                case 4:
                    System.out.print("Enter volume (0-100): ");
                    int volume = scanner.nextInt();
                    scanner.nextLine();
                    command = new AdjustVolumeCommand(musicPlayer, volume, user);
                    break;

                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            remote.executeCommand(command);

            System.out.println("Action executed by " + user + ": " + command.getDescription());

            System.out.print("Undo action? (yes/no): ");
            String undoOption = scanner.nextLine();

            if (undoOption.equalsIgnoreCase("yes")) {
                command.undo();
                System.out.println("Action undone.");
            }
        }

        System.out.println("\n--- Full History ---");

        Map<String, Integer> misconfigurationCounter = new HashMap<>();

        // Use of cmd and history of actiopns guided with ChatGPT
        
        for (Command cmd : remote.getHistory()) {

            String status = cmd.isUndone() ? " (undone)" : "";

            System.out.println(cmd.getDescription()
                    + " - User: "
                    + cmd.getUser()
                    + status);

            if (!cmd.isUndone()) {
                misconfigurationCounter.put(
                        cmd.getUser(),
                        misconfigurationCounter.getOrDefault(cmd.getUser(), 0) + 1
                );
            }
        }

        System.out.println("\n--- Investigating who misconfigured the devices ---");

        for (Map.Entry<String, Integer> entry : misconfigurationCounter.entrySet()) {
            System.out.println(entry.getKey()
                    + " performed "
                    + entry.getValue()
                    + " action(s) that altered the configuration.");
        }

        scanner.close();
    }
}
