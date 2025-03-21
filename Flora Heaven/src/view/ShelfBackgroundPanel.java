package view;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class ShelfBackgroundPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoader.shelfbackground, 0, 0, getWidth(), getHeight(), this);
    }
}
