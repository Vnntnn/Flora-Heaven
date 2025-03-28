package view.gameplay.Arcanashop;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class DaypapercardholderPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderArcanashop.Dayholder, 0, 0, getWidth(), getHeight(), this);
    }
}
