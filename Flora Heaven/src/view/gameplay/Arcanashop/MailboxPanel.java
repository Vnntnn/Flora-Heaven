package view.gameplay;

import javax.swing.*;
import java.awt.*;

public class MailboxPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderGameplay.mailsbox, 0, 0, getWidth(), getHeight(), this);
    }
}
