package main.view.gameplay.Treeshop;

import javax.swing.*;
import java.awt.*;

public class fbookPanel extends JPanel {
    public fbookPanel() {
        setOpaque(false);
        setLayout(null);

        ImageIcon originalIcon = AssetsLoaderTreeShop.fbook;
        Image scaledImage = originalIcon.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel gifLabel = new JLabel(scaledIcon);
        gifLabel.setBounds(60, 0, 1200, 700);
        add(gifLabel);
    }
}
