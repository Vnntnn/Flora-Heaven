package main.model.save;

import main.model.Player.Player;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PlayerDataSaver {
    private Player player;
    private static final String fileName = "player.dat";

    public static void savePlayer(Player player) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}