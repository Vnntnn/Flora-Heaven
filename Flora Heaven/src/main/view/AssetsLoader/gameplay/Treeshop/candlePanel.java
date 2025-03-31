package main.view.AssetsLoader.gameplay.Treeshop;

import javax.swing.*;
import java.awt.*;

public class candlePanel extends JPanel {
    public candlePanel() {
        setOpaque(false);
        setLayout(null);

        ImageIcon originalIcon = AssetsLoaderTreeShop.candle;
        Image scaledImage = originalIcon.getImage().getScaledInstance(1290, 755, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel gifLabel = new JLabel(scaledIcon);
        gifLabel.setBounds(45, 20, 1200, 700);
        add(gifLabel);
    }
}