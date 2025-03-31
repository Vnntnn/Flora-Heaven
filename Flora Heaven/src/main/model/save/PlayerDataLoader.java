package main.model.save;

import main.model.Player.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PlayerDataLoader {
    public static Player loadPlayer(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Player) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}