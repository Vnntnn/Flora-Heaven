package main.view.Gamewindow.lobby;

import javax.swing.*;
import java.awt.*;

public class RoleView {
    private JFrame frame;
    private JLayeredPane layeredPane;
    private JButton nextButton;

    public RoleView(Font customFont, Image background) {
        initializeUI(customFont, background);
    }

    private void initializeUI(Font customFont, Image background) {
        frame = new JFrame("Flora Heaven - Role");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 755);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        // Background
        JLabel backgroundLabel = new JLabel(new ImageIcon(background.getScaledInstance(1280, 720, Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(-10, -20, 1290, 755);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Title
        JLabel titleLabel = new JLabel("Role", SwingConstants.CENTER);
        titleLabel.setFont(customFont.deriveFont(50f));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(0, 225, 1290, 80);
        layeredPane.add(titleLabel, JLayeredPane.PALETTE_LAYER);

        // Role Description
        JLabel roleLabel = new JLabel("The Keeper of Flora Heaven", SwingConstants.CENTER);
        roleLabel.setFont(customFont.deriveFont(80f));
        roleLabel.setForeground(Color.BLACK);
        roleLabel.setBounds(0, 300, 1290, 200);
        layeredPane.add(roleLabel, JLayeredPane.PALETTE_LAYER);

        // Next Button
        nextButton = createStyledButton("Next", 1125, 630, 100, 50, customFont);
        layeredPane.add(nextButton, JLayeredPane.PALETTE_LAYER);

        frame.setContentPane(layeredPane);
        frame.setBackground(new Color(62, 39, 35));
    }

    private JButton createStyledButton(String text, int x, int y, int width, int height, Font font) {
        JButton button = new JButton(text);
        button.setFont(font.deriveFont(30f));
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

    public void setUndecorated(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUndecorated'");
    }

    public void setOpacity(float f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOpacity'");
    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }
}