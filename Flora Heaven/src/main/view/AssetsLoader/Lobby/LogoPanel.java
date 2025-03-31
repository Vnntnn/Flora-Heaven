package main.view.AssetsLoader.Lobby;

import java.awt.*;
import javax.swing.*;

public class LogoPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderLobby.logo, 0, 0, getWidth(), getHeight(), this);
    }
}
