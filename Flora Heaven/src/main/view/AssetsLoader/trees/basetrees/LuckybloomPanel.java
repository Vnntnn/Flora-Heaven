package main.view.AssetsLoader.trees.basetrees;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class LuckybloomPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        setOpaque(false);
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.luckybloom, 0, 0, getWidth(), getHeight(), this);
    }
}
