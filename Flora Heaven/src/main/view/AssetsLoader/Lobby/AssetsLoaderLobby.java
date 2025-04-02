package main.view.AssetsLoader.Lobby;

/**
* @author tipwareeetaokhotsee
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class AssetsLoaderLobby {
    public static ImageIcon lobbygif;
    protected static BufferedImage Lobbybackground;
    protected static BufferedImage Gameboard;
    protected static ImageIcon gif;
    private static AssetsLoaderLobby instance = new AssetsLoaderLobby();

    private AssetsLoaderLobby() {
        try {
            Lobbybackground = ImageIO.read(AssetsLoaderLobby.class.getResourceAsStream("/assets/Lobby/background.png"));
            Gameboard = ImageIO.read(AssetsLoaderLobby.class.getResourceAsStream("/assets/Lobby/woodboard.png"));

            URL imgURL = AssetsLoaderLobby.class.getResource("/assets/Lobby/animations/logo_with_gif.GIF");
            if (imgURL != null) {
                gif = new ImageIcon(imgURL);
            } else {
                System.err.println("Error: GIF not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssetsLoaderLobby getInstance() {
        return instance;
    }
}
