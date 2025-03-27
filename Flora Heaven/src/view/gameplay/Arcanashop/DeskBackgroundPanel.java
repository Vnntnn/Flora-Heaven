package view.gameplay.Arcanashop;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class DeskBackgroundPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderArcanashop.deskbackground, 0, 0, getWidth(), getHeight(), this);
    }
}
