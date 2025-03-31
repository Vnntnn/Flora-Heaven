package main.view.AssetsLoader.trees.treescombine;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SilentGuardianPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTreesCombine.SilentGuardian, 0, 0, getWidth(), getHeight(), this);
    }
}
