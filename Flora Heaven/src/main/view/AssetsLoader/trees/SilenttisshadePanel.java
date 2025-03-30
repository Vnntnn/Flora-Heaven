package main.view.AssetsLoader.trees;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class SilenttisshadePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        setOpaque(false);
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.silentisshade, 0, 0, getWidth(), getHeight(), this);
    }
}
