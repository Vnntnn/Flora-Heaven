package main.view.Gamewindow;

/**
 * @author Vnntnn
 */

import main.controller.BookController;
import main.view.AssetsLoader.books.ArrowsPanel;
import main.view.AssetsLoader.books.AssetsLoaderBook;
import main.view.AssetsLoader.books.BookbackgroundPanel;
import main.view.AssetsLoader.books.TreesDescriptionsPanel;

import java.awt.*;
import javax.swing.*;

public class BookWindow extends JFrame {
    private BookbackgroundPanel bookbackgroundpanel;
    private ArrowsPanel arrowspanel;
    private TreesDescriptionsPanel treesdescriptionspanel;
    private BookController bookcontroller;

    public BookWindow(BookController bookcontroller) {
        AssetsLoaderBook.getInstance();
        this.bookcontroller = bookcontroller;

        setTitle("Flora Heaven");
        setSize(1290, 755);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        bookbackgroundpanel = new BookbackgroundPanel();
        arrowspanel = new ArrowsPanel();
        treesdescriptionspanel = new TreesDescriptionsPanel();

        JLayeredPane layeredpane = new JLayeredPane();
        layeredpane.setPreferredSize(new Dimension(1290, 755));

        bookbackgroundpanel.setBounds(0, 0, 1290, 755);
        arrowspanel.setBounds(0, 0, 1290, 755);
        treesdescriptionspanel.setBounds(0, 0, 1290, 755);

        bookbackgroundpanel.setOpaque(false);
        treesdescriptionspanel.setOpaque(false);

        layeredpane.add(bookbackgroundpanel, Integer.valueOf(1));
        layeredpane.add(treesdescriptionspanel, Integer.valueOf(2));
        layeredpane.add(arrowspanel, Integer.valueOf(4));

        add(layeredpane, BorderLayout.CENTER);

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
    }

    public static void main(String[] args) {
        new BookWindow(new BookController());
    }
}