package view.gameplay.Arcanashop;

import javax.swing.*;
import java.awt.*;

public class MailboxPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderArcanashop.mailsbox, 0, 0, getWidth(), getHeight(), this);
    }
}
