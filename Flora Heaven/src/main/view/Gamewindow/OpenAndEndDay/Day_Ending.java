package main.view.Gamewindow.OpenAndEndDay;

import main.controller.common.SecretController;
import main.controller.OpenDay.ShowDayOpen;
import main.model.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Day_Ending extends JFrame {
    private String imagePath;
    private Player player;
    
    public Day_Ending(String imagePath, Player player) {
        this.imagePath = imagePath;
        this.player = player;
        initialize();
    }
    
    private void initialize() {
        setTitle("Flora Heaven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1290, 755);
        
        BackgroundPanel backgroundPanel = new BackgroundPanel(imagePath);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1728, 960));
        
        backgroundPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
        
        add(layeredPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(player.getDay()>=1 && player.getDay()<=5) {
                    new ShowDayOpen(player.getDay(),player);
                }
                else {
                    new SecretController(player);

                }
                dispose();
            }
        });
    }
    
    private static class BackgroundPanel extends JPanel {
        private BufferedImage image;
        private String imagePath;
        
        public BackgroundPanel(String imagePath) {
            this.imagePath = imagePath;
            setPreferredSize(new Dimension(1728, 960));
            loadImage();
            setLayout(null);
        }
        
        private void loadImage() {
            try {
                image = ImageIO.read(getClass().getResource(imagePath));
            } catch (IOException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}