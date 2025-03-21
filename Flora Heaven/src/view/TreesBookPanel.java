package view;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class TreesBookPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoader.treesbook, 0, 0, getWidth(), getHeight(), this);
    }
}
