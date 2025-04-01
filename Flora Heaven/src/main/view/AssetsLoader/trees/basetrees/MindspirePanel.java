package main.view.AssetsLoader.trees.basetrees;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class MindspirePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        setOpaque(false);
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.mindspire, 0, 0, getWidth(), getHeight(), this);
    }
}
