package main.view.AssetsLoader.books;

/**
 * @author Vnntnn
 */

import java.awt.*;
import javax.swing.*;

public class TreesDescriptionsPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 12; i++) {
            g.drawImage(AssetsLoaderBook.Trees[i], 0, 0, getWidth(), getHeight(), null);
        }
    }
}
