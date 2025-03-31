package main.view.AssetsLoader.trees.basetrees;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class Illumis_sproutPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        setOpaque(false);
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.illumissprout, 0, 0, getWidth(), getHeight(), this);
    }
}
