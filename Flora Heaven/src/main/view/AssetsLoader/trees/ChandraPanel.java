package main.view.AssetsLoader.trees;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class ChandraPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.chandra, 0, 0, getWidth(), getHeight(), this);
    }
}
