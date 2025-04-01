package main.view.AssetsLoader.Lobby;

import java.awt.*;
import javax.swing.*;

// ใน LobbyGifPanel.java
public class GifPanel extends JPanel {
    public GifPanel() {
        setOpaque(false);
        setLayout(null);

        int width = 1100;
        int height = 585;

        Image originalImage = AssetsLoaderLobby.gif.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        JLabel gifLabel = new JLabel(new ImageIcon(scaledImage));
        gifLabel.setBounds(0,0, width, height);

        add(gifLabel);
    }
}