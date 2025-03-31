package main.view.AssetsLoader.Lobby;

/**
* @author tipwareeetaokhotsee
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
//            logo = ImageIO.read(AssetsLoaderLobby.class.getResourceAsStream("/assets/Lobby/logo/logo_new.png"));

            gif = new ImageIcon(AssetsLoaderLobby.class.getResource("/Lobby/animations/logo_with_gif.GIF"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssetsLoaderLobby getInstance() {
        return instance;
    }
}
