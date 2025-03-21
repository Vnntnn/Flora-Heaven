package view;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class SubQuestPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoader.subquest, 0, 0, getWidth(), getHeight(), this);
    }
}
