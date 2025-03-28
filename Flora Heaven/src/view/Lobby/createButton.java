package view.Lobby;

import javax.swing.*;
import java.awt.*;

public class createButton extends JButton {
    public createButton(String text, int x, int y) {
        super(text); 
        setBounds(x, y, 150, 40);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 18));
        setLayout(null); 
    }
}

