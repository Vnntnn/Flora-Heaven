package main.view.AssetsLoader.books;

/**
 * @author Vnntnn
 */

import java.awt.*;
import javax.swing.*;

public class BookbackgroundPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderBook.bookbackground, 0, 0, getWidth(), getHeight(),null);
    }
}
