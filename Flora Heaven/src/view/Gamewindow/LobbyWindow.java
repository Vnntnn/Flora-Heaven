import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Lobby extends JPanel {
    private BufferedImage backgroundImage;
    private BufferedImage woodBoardImage;
    private ArrayList<Firefly> fireflies;
    private Controller controller;
    private static final int NUM_FIREFLIES = 120;

    public StartPage(Controller controller) {
        this.controller = controller;
        setLayout(null);
        loadImages();
        initFireflies();
        initButtons();

        // Animation Timer
        Timer timer = new Timer(50, e -> {
            controller.updateFireflies(getWidth(), getHeight());
            repaint();
        });
        timer.start();
    }

    private void loadImages() {
        try {
            backgroundImage = ImageIO.read(new File("src/background.PNG"));
            woodBoardImage = ImageIO.read(new File("src/woodboard.PNG"));
        } catch (IOException e) {
            System.out.println("Image not found!");
        }
    }

    private void initFireflies() {
        fireflies = controller.getFireflies();
    }

    private void initButtons() {
        JButton startButton = createButton("Start", 120, 350);
        JButton creditsButton = createButton("Credits", 120, 400);
        JButton quitButton = createButton("Quit", 120, 450);

        quitButton.addActionListener(e -> System.exit(0));

        add(startButton);
        add(creditsButton);
        add(quitButton);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 40);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 18));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(255, 183, 197));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE);
            }
        });

        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (backgroundImage != null) {
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        for (Firefly firefly : fireflies) {
            firefly.draw(g2d);
        }

        if (woodBoardImage != null) {
            g2d.drawImage(woodBoardImage, 0, 0, getWidth(), getHeight(), this);
        }

        g2d.setColor(new Color(99, 42, 38));
        g2d.drawString("Flora Heaven", 78, 193);
        g2d.setColor(new Color(244, 232, 193));
        g2d.drawString("Flora Heaven", 80, 190);
    }
}
