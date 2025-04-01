package main.view.AssetsLoader.gameplay.Arcanashop;

import java.awt.*;
import javax.swing.*;

public class ClockGIFPanel extends JPanel {
    public ClockGIFPanel() {
        setOpaque(false);

        ImageIcon originalIcon = AssetsLoaderArcanashop.clockGIF;
        Image scaledImage = originalIcon.getImage().getScaledInstance(1280, 722, Image.SCALE_DEFAULT);
        ImageIcon resizedGif = new ImageIcon(scaledImage);
        JLabel giflLabel = new JLabel(resizedGif);
        add(giflLabel);
    }
}