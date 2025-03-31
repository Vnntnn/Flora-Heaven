package main.controller;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chenl
 */
import main.model.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;


public class rolePage {
    private JFrame fr;
    private JPanel pTitle, pFootage, pTopage, pButton, pTop, pMain, pRole, pMid, pBG;
    private JLayeredPane pFrame, pBtnBack;
    private JLabel title, bgLabel, role;
    private JButton btnBack, btnConfirm, btnCancle;
    private ImageIcon background;

    public rolePage() {
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
            System.out.println("Font loaded successfully!");

            // Load animated GIF background
            URL bgUrl = openStoryPage.class.getResource("/assets/Role/bgRole.png"); // Changed to GIF
            if (bgUrl == null) {
                throw new FileNotFoundException("Background image not found: /img/bgRole.png");
            }
            ImageIcon unscaledIcon = new ImageIcon(bgUrl);
            Image scaledImage = unscaledIcon.getImage().getScaledInstance(1275, 720, Image.SCALE_DEFAULT);
            background = new ImageIcon(scaledImage);

            
            bgLabel = new JLabel(background);
            bgLabel.setBounds(0, 0, 1276, 720);
            
            pBG = new JPanel(null);
            pBG.setBounds(0, 0, width, height);
            pBG.setBackground(new Color(62, 39, 35));
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
            
            //set role 
            title = new JLabel("Role", SwingConstants.CENTER);
            title.setFont(customFont.deriveFont(50f));
            title.setForeground(Color.BLACK); 
            pTitle = new JPanel();
            pTitle.setPreferredSize(new Dimension(width,80));
            pTitle.add(title); pTitle.setOpaque(false);
            pTitle.setBounds(0, 225, width,80);
            role = new JLabel("The Keeper of Flora Heaven", SwingConstants.CENTER);
            role.setFont(customFont.deriveFont(80f));
            role.setForeground(Color.BLACK);
            pRole = new JPanel();
            pRole.add(role); pRole.setOpaque(false);
            pRole.setBounds(0, 300, width,200);
            
            //mid pane
            pMid = new JPanel();
            pMid.setLayout(null); 
            pMid.add(pTitle);
            pMid.add(pRole);
            pMid.setOpaque(false);
       
            
            //set top pane + empty top space
            pTop = new JPanel(new BorderLayout());
            pTop.setOpaque(false);
            pTop.add(pButton, BorderLayout.CENTER);
            
            //set main pane
            pMain = new JPanel(new BorderLayout());
            pMain.setBounds(0, 0, width, height);
            pMain.setOpaque(false);
            pMain.add(pTop, BorderLayout.SOUTH); 
            pMain.add(pMid);

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
                fr.dispose();
                new showDayOpen(new Player().getDay());
            });
            timer2.setRepeats(false);
            timer2.start();
        });     
    }
  
    public static void main(String[] args) {
        new rolePage();
    }
}