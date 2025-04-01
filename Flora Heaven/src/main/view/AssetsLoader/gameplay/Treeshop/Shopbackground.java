package main.view.AssetsLoader.gameplay.Treeshop;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class Shopbackground extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTreeShop.shopbackground, 0, 0, getWidth(), getHeight(), this);
    }
}
