package Day_Opening;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Opening_day extends JFrame {
    private String imagePath;
    
    public Opening_day(String imagePath) {
        this.imagePath = imagePath;
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
    
    public static void showDay(int dayNumber) {
        String imagePath = "/Images/Day_" + dayNumber + "_Op.png";
        SwingUtilities.invokeLater(() -> {
            Opening_day frame = new Opening_day(imagePath);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        showDay(3); // 1-5
    }
}