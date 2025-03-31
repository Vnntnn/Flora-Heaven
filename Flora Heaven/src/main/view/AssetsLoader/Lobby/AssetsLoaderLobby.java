package main.view.AssetsLoader.Lobby;

/*
  @author tipwareeetaokhotsee
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderLobby {
    protected static BufferedImage Lobbybackground;
    protected static BufferedImage Gameboard;
    protected static BufferedImage logo;
    protected static ImageIcon lobbygif;
    private static AssetsLoaderLobby instance = new AssetsLoaderLobby();

    private AssetsLoaderLobby() {
        try {
            Lobbybackground = ImageIO.read(AssetsLoaderLobby.class.getResourceAsStream("/assets/Lobby/background.png"));
            Gameboard = ImageIO.read(AssetsLoaderLobby.class.getResourceAsStream("/assets/Lobby/woodboard.png"));
            logo = ImageIO.read(AssetsLoaderLobby.class.getResourceAsStream("/assets/Lobby/logo.png"));
            lobbygif = new ImageIcon(AssetsLoaderLobby.class.getResource("/assets/Lobby/lobbygif.GIF"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssetsLoaderLobby getInstance() {
        return instance;
    }
}
