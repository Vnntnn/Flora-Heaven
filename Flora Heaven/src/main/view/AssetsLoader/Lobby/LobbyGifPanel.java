package main.view.AssetsLoader.Lobby;

import java.awt.*;
import javax.swing.*;

// ใน LobbyGifPanel.java
public class LobbyGifPanel extends JPanel {
    public LobbyGifPanel() {
        setOpaque(false);
        setLayout(null);

        int width = 1290;
        int height = 755;

        Image originalImage = AssetsLoaderLobby.lobbygif.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        JLabel gifLabel = new JLabel(new ImageIcon(scaledImage));
        int x = (1290 - width) / 2;
        int y = 100;
        gifLabel.setBounds(x, y, width, height);

        add(gifLabel);
    }
}
