package main.view.AssetsLoader.gameplay.Treeshop;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class UnavailableTrees extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 12; i++) {
            g.drawImage(AssetsLoaderTreeShop.unavailabletrees[i], 0, 0, getWidth(), getHeight(), this);
        }
    }
}
