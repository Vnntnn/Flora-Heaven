package main.view.AssetsLoader.trees.basetrees;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class Bloodvalor_blossomPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.bloodvalorblossom, 0, 0, getWidth(), getHeight(), this);
    }

    public Bloodvalor_blossomPanel(){
        setOpaque(false);
    }
}