package view;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class MainQuestPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoader.mainquest, 0, 0, getWidth(), getHeight(), this);
    }
}
