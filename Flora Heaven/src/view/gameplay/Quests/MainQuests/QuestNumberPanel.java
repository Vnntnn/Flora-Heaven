package view.gameplay.Quests.MainQuests;

// ***
// Author: Vnntnn
// ***

import model.Player.Player;
import java.awt.*;
import javax.swing.*;

public class QuestNumberPanel extends JPanel {
    private Player player;

    public QuestNumberPanel(Player player) {
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderMainQuests.Questsnumber[player.getDay() - 1], 0, 0, getWidth(), getHeight(), this);
    }
}
