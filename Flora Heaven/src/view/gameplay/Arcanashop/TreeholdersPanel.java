package view.gameplay;

import javax.swing.*;
import java.awt.*;

public class TreeholdersPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 12; i++) {
            JPanel panel = new JPanel();
            g.drawImage(AssetsLoaderGameplay.treeholder[i], 0, 0, getWidth(), getHeight(), this);
        }
    }
}
