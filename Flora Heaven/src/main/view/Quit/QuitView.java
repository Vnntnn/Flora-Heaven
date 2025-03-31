package main.view.Quit;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class QuitView {
    private JFrame frame;
    private JLayeredPane mainPane;
    private JLabel titleLabel;
    private JButton yesButton;
    private JButton noButton;
    private BufferedImage backgroundImage;

    public QuitView(Font customFont, Image background) {
        this.backgroundImage = toBufferedImage(background);
        initializeUI(customFont);
    }

    private void initializeUI(Font customFont) {
        // ตั้งค่าหลักของ Frame
        frame = new JFrame("Flora Heaven");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 755);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // ใช้ JLayeredPane เป็น Container หลัก
        mainPane = new JLayeredPane();
        mainPane.setLayout(null);
        mainPane.setPreferredSize(new Dimension(1290, 755));

        // เพิ่มพื้นหลัง
        JLabel bgLabel = new JLabel(new ImageIcon(backgroundImage));
        bgLabel.setBounds(0, 0, 1290, 755);
        mainPane.add(bgLabel, JLayeredPane.DEFAULT_LAYER);

        // Title
        titleLabel = new JLabel("Do You Want to Quit?", SwingConstants.CENTER);
        titleLabel.setFont(customFont.deriveFont(70f));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 200, 1290, 100);
        mainPane.add(titleLabel, JLayeredPane.PALETTE_LAYER);

        // Yes/No Buttons
        yesButton = createRoundButton("YES", Color.decode("#80CAFF"), customFont.deriveFont(40f));
        yesButton.setBounds(350, 360, 250, 100);
        mainPane.add(yesButton, JLayeredPane.PALETTE_LAYER);

        noButton = createRoundButton("NO", Color.decode("#80CAFF"), customFont.deriveFont(40f));
        noButton.setBounds(680, 360, 250, 100);
        mainPane.add(noButton, JLayeredPane.PALETTE_LAYER);

        frame.setContentPane(mainPane);
    }

    private JButton createRoundButton(String text, Color bgColor, Font font) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(bgColor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        button.setFont(font);
        button.setForeground(Color.BLACK);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        return button;
    }

    private BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bimage = new BufferedImage(
            img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }

    // Getter methods
    public JButton getYesButton() { return yesButton; }
    public JButton getNoButton() { return noButton; }

    public void show() { frame.setVisible(true); }
    public void close() { frame.dispose(); }
}