package main.view.AssetsLoader.trees.treescombine;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ValorvinePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTreesCombine.Valorvine, 0, 0, getWidth(), getHeight(), this);
    }
}
