package Day_Opening;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Start_day extends JLayeredPane {
    private BufferedImage image;

    public Start_day() {
        setPreferredSize(new Dimension(1728, 960));
        loadImage();
        
        // JLayeredPane requires manual layout management
        setLayout(null);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(getClass().getResource("/Images/IMG_4719.png"));
            
            if (image == null) {
                createFallbackImage();
            }
        } catch (IOException | IllegalArgumentException e) {
            createFallbackImage();
        }
    }

    private void createFallbackImage() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}