package Day_Opening;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Third_day_img extends JPanel{
    private BufferedImage image;

    public Third_day_img() {
        setPreferredSize(new Dimension(1728, 960));
        loadImage();
        
        // JLayeredPane requires manual layout management
        setLayout(null);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(getClass().getResource("/Images/IMG_4835.png"));
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