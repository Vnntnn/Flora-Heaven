package main.view.treescombine;

import java.awt.Graphics;

import javax.swing.JPanel;

public class FortunaeVinePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTreesCombine.FortunaeVine, 0, 0, getWidth(), getHeight(), this);
    }
}
