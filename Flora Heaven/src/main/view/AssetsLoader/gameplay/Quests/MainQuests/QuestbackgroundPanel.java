package main.view.AssetsLoader.gameplay.Quests.MainQuests;

// ***
// Author: Vnntnn
// ***

import java.awt.*;
import javax.swing.*;

public class QuestbackgroundPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderMainQuests.Questbackground, 0, 0, getWidth(), getHeight(), this);
    }
}
