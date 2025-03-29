package main.controller;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chenl
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;


public class openStoryPage{
    private JFrame fr;
    private JPanel pTitle, pFootage, pTopage, pButton, pTop, pMain, pConCan, pMid, pBG;
    private JLayeredPane pFrame, pBtnBack;
    private JLabel title, bgLabel;
    private JButton btnBack, btnConfirm, btnCancle;
    private ImageIcon background;

    public openStoryPage() {
        //set size screen
        int width = 1290;
        int height = 755;

        fr = new JFrame("Flora Heaven");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(new Dimension(width, height));
        fr.setResizable(false);

        try {
            // Load custom font
            InputStream fontStream = openStoryPage.class.getResourceAsStream("/Font/Pixelpoint.ttf");
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found in resources: /Font/Pixelpoint.ttf");
            }
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            // Load animated GIF background
            URL bgUrl = openStoryPage.class.getResource("/assets/Openstory/storyOpen.gif"); // Changed to GIF
            if (bgUrl == null) {
                throw new FileNotFoundException("Background image not found: /img/storyOpen.gif");
            }
            ImageIcon unscaledIcon = new ImageIcon(bgUrl);
            Image scaledImage = unscaledIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
            background = new ImageIcon(scaledImage);


            bgLabel = new JLabel(background);
            bgLabel.setBounds(-10, -20, width, height);

            pBG = new JPanel(null);
            pBG.setBounds(0, 0, width, height);
            pBG.add(bgLabel);

            //set back button
            pButton = new JPanel();
            pButton.setLayout(null);
            btnBack = new JButton("Next");
            btnBack.setBounds(1125, 0, 100, 50);
            btnBack.setFont(customFont.deriveFont(30f));
            btnBack.setForeground(Color.BLACK);
            btnBack.setBackground(Color.YELLOW);
            btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
            btnBack.setVerticalTextPosition(SwingConstants.CENTER);
            btnBack.setContentAreaFilled(true);
            btnBack.setBorderPainted(false);
            btnBack.setFocusPainted(false);
            btnBack.setOpaque(true);
            btnBack.setMargin(new Insets(0, 0, 0, 0));
            btnBack.setBorder(null);
            pButton.add(btnBack);
            pButton.setPreferredSize(new Dimension(width,130));
            pButton.setOpaque(false);

            //set empty space panels             
            pTopage = new JPanel();
            pTopage.setOpaque(false);
            pTopage.setPreferredSize(new Dimension(width, 40));

            //set top pane + empty top space
            pTop = new JPanel(new BorderLayout());
            pTop.setOpaque(false);
            pTop.add(pButton);

            //set main pane
            pMain = new JPanel(new BorderLayout());
            pMain.setBounds(0, 0, width, height);
            pMain.setOpaque(false);
            pMain.add(pTop, BorderLayout.SOUTH);

            //set layered pane
            pFrame = new JLayeredPane();
            pFrame.setBounds(0, 0, width, height);
            pFrame.add(pBG, JLayeredPane.DEFAULT_LAYER);
            pFrame.add(pMain, JLayeredPane.PALETTE_LAYER);

            //set JFrame
            fr.setContentPane(pFrame);
            fr.setVisible(true);

        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            // Fallback to solid color background
            pBG = new JPanel();
            pBG.setBackground(Color.BLACK);
            pBG.setBounds(0, 0, width, height);
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font or image!");
            e.printStackTrace();
        }

        //event button change color
        btnBack.addActionListener(e -> {
            btnBack.setBackground(Color.WHITE);

            Timer timer1 = new Timer(500, ev -> {
                btnBack.setBackground(Color.YELLOW);
            });
            timer1.setRepeats(false);
            timer1.start();

            Timer timer2 = new Timer(600, ev -> {
                new rolePage();
            });
            timer2.setRepeats(false);
            timer2.start();
        });
    }
}