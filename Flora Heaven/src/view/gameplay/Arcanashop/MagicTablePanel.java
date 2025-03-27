package view.gameplay;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class MagicTablePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderGameplay.magictable, 0, 0, getWidth(), getHeight(), this);
    }
}
