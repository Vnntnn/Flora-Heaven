package main.view.Fail;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class FailView {
    private JFrame frame;
    private JButton nextButton;
    
    public static class StoryLabelInfo {
        public final String text;
        public final float fontSize;
        public final int x;
        public final int y;
        public final int width;
        public final int height;
        
        public StoryLabelInfo(String text, float fontSize, int x, int y, int width, int height) {
            this.text = text;
            this.fontSize = fontSize;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public FailView(Font customFont, Image backgroundImage, Map<String, StoryLabelInfo> labelInfos) {
        initializeUI(customFont, backgroundImage, labelInfos);
    }

    private void initializeUI(Font customFont, Image backgroundImage, Map<String, StoryLabelInfo> labelInfos) {
        frame = new JFrame("Flora Heaven - Fail");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 755);
        frame.setResizable(false);

        JLayeredPane layeredPane = new JLayeredPane();
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
        nextButton = new JButton("Next");
        nextButton.setFont(customFont.deriveFont(30f));
        nextButton.setForeground(Color.BLACK);
        nextButton.setBackground(Color.YELLOW);
        nextButton.setBounds(1125, 630, 100, 50);
        nextButton.setBorderPainted(false);
        nextButton.setFocusPainted(false);
        layeredPane.add(nextButton, JLayeredPane.PALETTE_LAYER);

        frame.setContentPane(layeredPane);
    }

    public JFrame getFrame() {
        return frame;
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
}