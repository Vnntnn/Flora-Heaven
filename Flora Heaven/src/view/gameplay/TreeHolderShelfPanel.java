package view.gameplay;

// ***
// Author: Vnntnn
// ***

import view.menu.AssetsLoaderGameplay;

import javax.swing.*;
import java.awt.*;

public class TreeHolderShelfPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderGameplay.treeholdershelf, 0, 0, getWidth(), getHeight(), this);
    }
}
