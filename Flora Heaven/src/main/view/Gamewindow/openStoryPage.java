package main.view.Gamewindow;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class openStoryPage {
    private JFrame frame;
    private JLayeredPane layeredPane;
    private JButton nextButton;
    private Font customFont;

    public openStoryPage(Font customFont, Image backgroundImage, Map<String, StoryLabelInfo> labelInfos) {
        this.customFont = customFont;
        initializeUI(backgroundImage, labelInfos);
        this.show();
    }

    private void initializeUI(Image backgroundImage, Map<String, StoryLabelInfo> labelInfos) {
        frame = new JFrame("Flora Heaven");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 755);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        // Background
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage.getScaledInstance(1280, 720, Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(-10, -18, 1290, 755);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Story labels
        for (Map.Entry<String, StoryLabelInfo> entry : labelInfos.entrySet()) {
            StoryLabelInfo info = entry.getValue();
            JLabel label = new JLabel(info.text);
            label.setFont(customFont.deriveFont(info.fontSize));
            label.setForeground(Color.BLACK);
            label.setBounds(info.x, info.y, info.width, info.height);
            layeredPane.add(label, JLayeredPane.PALETTE_LAYER);
        }

        // Next button
        nextButton = createStyledButton("Next", 1123, 628, 100, 50);
        layeredPane.add(nextButton, JLayeredPane.PALETTE_LAYER);

        frame.setContentPane(layeredPane);
    }

    private JButton createStyledButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(customFont.deriveFont(30f));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.YELLOW);
        button.setBounds(x, y, width, height);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        return button;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }

    public static class StoryLabelInfo {
        public final String text;
        public final float fontSize;
        public final int x, y, width, height;

        public StoryLabelInfo(String text, float fontSize, int x, int y, int width, int height) {
            this.text = text;
            this.fontSize = fontSize;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}