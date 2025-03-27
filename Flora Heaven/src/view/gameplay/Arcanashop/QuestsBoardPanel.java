package view.gameplay;

// ***
// Author: Vnntnn
// ***

import model.Gameplay.Player.Player;

import javax.swing.*;
import java.awt.*;

public class QuestsBoardPanel extends JPanel {
    private Player player;

    public QuestsBoardPanel(Player player) {
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderGameplay.questboard, 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString(player.getCoins() + "", 1100, 110);
    }
}
