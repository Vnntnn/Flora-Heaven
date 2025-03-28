package view.Credits;

/*
@author chenl
*/

import java.awt.*;
import javax.swing.*;

public class CreditsbackgroundPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderCredits.creditsbackground, 0, 0, getWidth(), getHeight(), this);
    }
}
