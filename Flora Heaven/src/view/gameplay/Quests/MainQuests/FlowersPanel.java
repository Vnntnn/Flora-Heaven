package view.gameplay.Quests.MainQuests;

// ***
// Author: Vnntnn
// ***

import java.awt.*;
import javax.swing.*;

public class FlowersPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderMainQuests.Flowers, 0, 0, getWidth(), getHeight(), this);
    }
}
