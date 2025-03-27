package Day_Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Second_day_img extends JPanel{
    private BufferedImage image;

    public Second_day_img() {
        setPreferredSize(new Dimension(1728, 960));
        loadImage();

        setLayout(null);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(getClass().getResource("/Images/Day_2_End.png"));
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
