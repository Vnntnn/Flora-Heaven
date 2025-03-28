package view.Lobby;

import javax.swing.*;
import java.awt.*;

public class GameboardPanel extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(AssetsLoaderLobby.Gameboard,0,0,getWidth(),getHeight(),this);
    }
}
