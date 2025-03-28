package view.Lobby;

import javax.swing.*;
import java.awt.*;

public class createButton extends JButton {
    JButton button;

    public createButton(String text, int x, int y) {
        setLayout(null);  // กำหนด Layout เป็น null เพื่อให้ใช้ setBounds ได้
        setOpaque(false);

        button = new JButton(text);
        button.setBounds(570, 350, 150, 40);
        button.setBounds(x, y, 150, 40);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 18));
    }

    public JButton getButton() {
        return button;
    }
}
