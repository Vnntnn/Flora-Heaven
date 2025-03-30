package main.view.AssetsLoader.gameplay.Arcanashop;

// ***
// Author: Vnntnn
// ***

import main.model.Player.Player;
import javax.swing.*;
import java.awt.*;

public class DaysPanel extends JPanel {
    private Player player;

    public DaysPanel(Player player) {
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderArcanashop.Dayscard[player.getDay() - 1], 0, 0, getWidth(), getHeight(), this);
    }
}
