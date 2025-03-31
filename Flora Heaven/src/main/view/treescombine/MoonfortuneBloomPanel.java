package main.view.treescombine;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MoonfortuneBloomPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTreesCombine.MoonfortuneBloom, 0, 0, getWidth(), getHeight(), this);
    }
}
