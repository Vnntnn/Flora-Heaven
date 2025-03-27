package view.trees;

// ***
// Author: Vnntnn
// ***

import view.AssetsLoaderTrees;

import javax.swing.*;
import java.awt.*;

public class HuoluPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.huolu, 0, 0, getWidth(), getHeight(), this);
    }
}
