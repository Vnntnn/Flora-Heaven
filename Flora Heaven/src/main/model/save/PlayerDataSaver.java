package main.model.save;

import main.model.Player.Player;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PlayerDataSaver {
    public static void savePlayer(Player player, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
