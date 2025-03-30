package main.view.AssetsLoader.books;

/**
 * @author Vnntnn
 */

import main.view.AssetsLoader.gameplay.Treeshop.AssetsLoaderTreeShop;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class ArrowsPanel extends JPanel {
    public ArrowsPanel() {
        setOpaque(false);
        setLayout(null);

        URL gifUrl = AssetsLoaderBook.class.getResource("/assets/Book/ArrowsPage/both_arrow.GIF");
        if (gifUrl != null) {
            ImageIcon originalIcon = new ImageIcon(gifUrl);
            JLabel gifLabel = new JLabel(originalIcon);
            gifLabel.setBounds(0, 0, originalIcon.getIconWidth(), originalIcon.getIconHeight());
            add(gifLabel);
        } else {
            System.err.println("GIF resource not found!");
        }
    }
}