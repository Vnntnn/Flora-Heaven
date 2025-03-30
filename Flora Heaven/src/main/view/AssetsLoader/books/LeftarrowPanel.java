package main.view.AssetsLoader.books;

/**
 * @author Vnntnn
 */

import main.view.AssetsLoader.gameplay.Treeshop.AssetsLoaderTreeShop;

import java.awt.*;
import javax.swing.*;

public class LeftarrowPanel extends JPanel {
    public LeftarrowPanel() {
        setOpaque(false);
        setLayout(null);

        ImageIcon originalIcon = AssetsLoaderBook.navleft;
        Image scaledImage = originalIcon.getImage().getScaledInstance(1290, 755, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel leftarr = new JLabel(scaledIcon);
        leftarr.setBounds(45, 20, 1200, 700);
        add(leftarr);
    }
}
