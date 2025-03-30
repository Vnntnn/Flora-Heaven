package main.view.Gamewindow;

/**
 * @author Vnntnn
 */

import main.controller.BookController;
import main.view.AssetsLoader.books.*;

import java.awt.*;
import javax.swing.*;

public class BookWindow extends JFrame {
    private BookbackgroundPanel bookbackgroundpanel;
    private TreesDescriptionsPanel treesdescriptionspanel;
    private LeftarrowPanel leftarrowpanel;
    private RightarrowPanel rightarrowpanel;
    private BookController bookcontroller;

    public BookWindow(BookController bookcontroller) {
        AssetsLoaderBook.getInstance();
        this.bookcontroller = bookcontroller;

        setTitle("Flora Heaven");
        setSize(1290, 755);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        bookbackgroundpanel = new BookbackgroundPanel();
        treesdescriptionspanel = new TreesDescriptionsPanel();
        leftarrowpanel = new LeftarrowPanel();
        rightarrowpanel = new RightarrowPanel();

        JLayeredPane layeredpane = new JLayeredPane();
        layeredpane.setPreferredSize(new Dimension(1290, 755));

        bookbackgroundpanel.setBounds(0, 0, 1290, 755);
        treesdescriptionspanel.setBounds(0, 0, 1290, 755);

        bookbackgroundpanel.setOpaque(false);
        treesdescriptionspanel.setOpaque(false);

        layeredpane.add(bookbackgroundpanel, Integer.valueOf(1));
        layeredpane.add(treesdescriptionspanel, Integer.valueOf(2));
        layeredpane.add(leftarrowpanel, Integer.valueOf(3));
        layeredpane.add(rightarrowpanel, Integer.valueOf(4));

        add(layeredpane, BorderLayout.CENTER);

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
    }

    public static void main(String[] args) {
        new BookWindow(new BookController());
    }
}