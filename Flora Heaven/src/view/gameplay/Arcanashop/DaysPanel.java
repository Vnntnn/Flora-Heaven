package view.gameplay;

import model.Gameplay.Player.Player;

import javax.swing.*;
import java.awt.*;

public class DaysPanel extends JPanel {
    Player player = new Player();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderGameplay.Dayscard[player.getDay() - 1], 0, 0, getWidth(), getHeight(), this);
    }
}
