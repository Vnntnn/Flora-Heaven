package main.view.AssetsLoader.gameplay.Treeshop;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class Shoplogo extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTreeShop.shoplogo, 0, 0, getWidth(), getHeight(), this);
    }
}
