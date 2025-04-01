package main.view.Gamewindow.Ending;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class EndingView {
    private JFrame frame;
    private JLayeredPane layeredPane;
    private JLabel backgroundLabel;
    private JButton nextButton;
    private Font customFont;

    public EndingView(Font customFont, Image backgroundImage, Map<String, StoryLabelInfo> labelInfos) {
        this.customFont = customFont;
        initializeUI(backgroundImage, labelInfos);
    }

    private void initializeUI(Image backgroundImage, Map<String, StoryLabelInfo> labelInfos) {
        frame = new JFrame("Flora Heaven - Ending");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 755);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        // Background
        backgroundLabel = new JLabel(new ImageIcon(backgroundImage.getScaledInstance(1280, 720, Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(-10, -18, 1290, 755);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Story labels
        for (Map.Entry<String, StoryLabelInfo> entry : labelInfos.entrySet()) {
            StoryLabelInfo info = entry.getValue();
            JLabel label = new JLabel(info.text);
            label.setFont(customFont.deriveFont(info.fontSize));
            label.setForeground(info.color);
            label.setBounds(info.x, info.y, info.width, info.height);
            layeredPane.add(label, JLayeredPane.PALETTE_LAYER);
        }

        // Next button with new style
        nextButton = new JButton("Next");
        nextButton.setBounds(1125,630 , 100, 50);
        nextButton.setFont(customFont.deriveFont(30f));
        nextButton.setForeground(Color.BLACK);
        nextButton.setBackground(Color.YELLOW);
        nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
        nextButton.setVerticalTextPosition(SwingConstants.CENTER);
        nextButton.setContentAreaFilled(true);
        nextButton.setBorderPainted(false);
        nextButton.setFocusPainted(false);
        nextButton.setOpaque(true);
        nextButton.setMargin(new Insets(0, 0, 0, 0));
        nextButton.setBorder(null);
        layeredPane.add(nextButton, JLayeredPane.PALETTE_LAYER);

        frame.setContentPane(layeredPane);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public static class StoryLabelInfo {
        public final String text;
        public final float fontSize;
        public final int x, y, width, height;
        public final Color color;

        public StoryLabelInfo(String text, float fontSize, int x, int y, int width, int height) {
            this(text, fontSize, x, y, width, height, Color.BLACK);
        }

        public StoryLabelInfo(String text, float fontSize, int x, int y, int width, int height, Color color) {
            this.text = text;
            this.fontSize = fontSize;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }
    }
}