package view.gameplay;

import javax.swing.*;
import java.awt.*;

public class DaypapercardholderPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderGameplay.Dayholder, 0, 0, getWidth(), getHeight(), this);
    }
}
