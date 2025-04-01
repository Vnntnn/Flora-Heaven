package main.view.AssetsLoader.trees.treescombine;

import java.awt.Graphics;

import javax.swing.JPanel;

public class HeartEclipsePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTreesCombine.HeartEclipse, 0, 0, getWidth(), getHeight(), this);
    }
}
