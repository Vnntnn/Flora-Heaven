package main.view.Lobby;

/*
  @author tipwareeetaokhotsee
*/

import javax.swing.*;
import java.awt.*;

public class LobbybackgroundPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderLobby.Lobbybackground,0,0,getWidth(),getHeight(),this);
    }
}
