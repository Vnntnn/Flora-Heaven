package main.view.Gamewindow.Gameplay;

/**
 * @author Vnntnn
 */

import main.controller.gameplay.BookController;
import main.view.AssetsLoader.books.*;

import java.awt.*;
import javax.swing.*;

public class BookWindow extends JFrame {
    private BookbackgroundPanel bookbackgroundpanel;
    private TreesDescriptionsPanel treesdescriptionspanel;
    private LeftarrowPanel leftarrowpanel;
    private RightarrowPanel rightarrowpanel;
    private combinePanel combinepanel;
    private SwapingPagePanel swapingPagePanel;
    private JButton[] navbutton;
    private JPanel[] navpanel;
    private BookController bookcontroller;

    public BookWindow(BookController bookcontroller) {
        AssetsLoaderBook.getInstance();
        this.bookcontroller = bookcontroller;

        setTitle("Flora Heaven");
        setSize(1290, 755);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        bookbackgroundpanel = new BookbackgroundPanel();
        treesdescriptionspanel = new TreesDescriptionsPanel(bookcontroller);
        combinepanel = new combinePanel(bookcontroller);
        swapingPagePanel = new SwapingPagePanel();
        leftarrowpanel = new LeftarrowPanel();
        rightarrowpanel = new RightarrowPanel();

        navpanel = new JPanel[2];
        navbutton = new JButton[2];
        for (int i = 0; i < navbutton.length; i++) {
            navpanel[i] = new JPanel(new GridLayout(1, 1));
            navpanel[i].setBackground(new Color(0, 0, 0, 0));

            navbutton[i] = new JButton();
            navbutton[i].setBorderPainted(false);
            navbutton[i].setContentAreaFilled(false);
            navbutton[i].setFocusPainted(false);

            navpanel[i].add(navbutton[i]);
        }

        navbutton[0].addActionListener(e -> bookcontroller.prevPage());
        navbutton[1].addActionListener(e -> bookcontroller.nextPage());

        JLayeredPane layeredpane = new JLayeredPane();
        layeredpane.setPreferredSize(new Dimension(1290, 755));

        bookbackgroundpanel.setBounds(0, 0, 1290, 755);
        treesdescriptionspanel.setBounds(0, 0, 1290, 755);
        combinepanel.setBounds(0, 0, 1290, 755);
        leftarrowpanel.setBounds(0, 0, 1290, 755);
        rightarrowpanel.setBounds(0, 0, 1290, 755);
        swapingPagePanel.setBounds(0, 0, 1290, 755);

        int y = 280;
        int width = 180;
        int height = 180;
        navpanel[0].setBounds(70, y, width, height);
        navpanel[1].setBounds(1110, y, width, height);

        bookbackgroundpanel.setOpaque(false);
        treesdescriptionspanel.setOpaque(false);
        combinepanel.setOpaque(false);

        layeredpane.add(bookbackgroundpanel, Integer.valueOf(1));
        layeredpane.add(treesdescriptionspanel, Integer.valueOf(2));
        layeredpane.add(combinepanel, Integer.valueOf(2));
        layeredpane.add(swapingPagePanel, Integer.valueOf(4));
        layeredpane.add(leftarrowpanel, Integer.valueOf(5));
        layeredpane.add(rightarrowpanel, Integer.valueOf(5));

        for (int i = 0; i < navpanel.length; i++) {
            layeredpane.add(navpanel[i], Integer.valueOf(5));
        }

        add(layeredpane, BorderLayout.CENTER);

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
    }

    public void showSwappingAnimation(boolean isNext) {
        // ซ่อน Panel หลักชั่วคราว
        treesdescriptionspanel.setVisible(false);
        combinepanel.setVisible(false);

        // แสดง animation
        swapingPagePanel.setActiveAnimation(isNext ? 0 : 1);
        swapingPagePanel.setVisible(true);
        swapingPagePanel.repaint();

        Timer timer = new Timer(700, e -> {
            // แสดง Panel หลักตามสถานะปัจจุบัน
            treesdescriptionspanel.setVisible(bookcontroller.isShowingTrees());
            combinepanel.setVisible(!bookcontroller.isShowingTrees());

            swapingPagePanel.setVisible(false);
            ((Timer)e.getSource()).stop();
        });
        timer.setRepeats(false);
        timer.start();
    }
}