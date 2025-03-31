package main.view.AssetsLoader.Lobby;

import java.awt.*;
import javax.swing.*;

public class LobbyGifPanel extends JPanel {
    public LobbyGifPanel() {
        setOpaque(false);
        setLayout(null);

        ImageIcon oimg = AssetsLoaderLobby.lobbygif;
        Image simg = oimg.getImage();
        ImageIcon simg2 = new ImageIcon(simg);

        JLabel logo = new JLabel(simg2);
        logo.setBounds(0, 0, getWidth(), getHeight());
        add(logo);
    }
}
