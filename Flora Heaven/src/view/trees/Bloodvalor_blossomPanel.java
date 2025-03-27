package view.trees;

// ***
// Author: Vnntnn
// ***

import model.Tree.Tree;
import view.AssetsLoaderTrees;

import javax.swing.*;
import java.awt.*;

public class BloodvalorBlossomPanel extends Tree {
    private JPanel panel;

    public BloodvalorBlossomPanel() {
        super("Bloodvalor Blossom", 100.0, 1);
        this.panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(AssetsLoaderTrees.bloodvalorblossom, 0, 0, getWidth(), getHeight(), this);
            }
        };
    }

    public JPanel getPanel() {
        return panel;
    }
}
