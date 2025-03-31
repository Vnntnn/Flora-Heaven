package main.view.Restart;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class RestartView {
    private JFrame frame;
    private JLabel btnYes;
    private JLabel btnNo;
    
    public static class LabelInfo {
        public final String text;
        public final float fontSize;
        public final int x;
        public final int y;
        public final int width;
        public final int height;
        
        public LabelInfo(String text, float fontSize, int x, int y, int width, int height) {
            this.text = text;
            this.fontSize = fontSize;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public RestartView(Font customFont, Image backgroundImage, 
                      Image yesButtonImage, Image noButtonImage,
                      Map<String, LabelInfo> labelInfos) {
        initializeUI(customFont, backgroundImage, yesButtonImage, noButtonImage, labelInfos);
    }

    private void initializeUI(Font customFont, Image backgroundImage, 
                            Image yesButtonImage, Image noButtonImage,
                            Map<String, LabelInfo> labelInfos) {
        frame = new JFrame("Flora Heaven - Restart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 755);
        frame.setResizable(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        // Background
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage.getScaledInstance(1280, 720, Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(-10, -18, 1290, 755);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Text labels
        for (Map.Entry<String, LabelInfo> entry : labelInfos.entrySet()) {
            LabelInfo info = entry.getValue();
            JLabel label = new JLabel(info.text);
            label.setFont(customFont.deriveFont(info.fontSize));
            label.setForeground(Color.BLACK);
            label.setBounds(info.x, info.y, info.width, info.height);
            layeredPane.add(label, JLayeredPane.PALETTE_LAYER);
        }

        // Yes Button
        btnYes = new JLabel(new ImageIcon(yesButtonImage));
        btnYes.setBounds(220, 350, 380, 120);
        layeredPane.add(btnYes, JLayeredPane.PALETTE_LAYER);

        // No Button
        btnNo = new JLabel(new ImageIcon(noButtonImage));
        btnNo.setBounds(650, 350, 380, 120);
        layeredPane.add(btnNo, JLayeredPane.PALETTE_LAYER);

        frame.setContentPane(layeredPane);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getYesButton() {
        return btnYes;
    }

    public JLabel getNoButton() {
        return btnNo;
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }
}