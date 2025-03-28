package view.Gamewindow;

import view.Credits.CreditsbackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreditsWindow extends JFrame {
    private JPanel panel;
    private JLabel titleLabel;
    private JButton backButton;
    private CreditsbackgroundPanel creditsbackgroundpanel;

    public CreditsWindow() {
        setTitle("Flora Heaven");
        setSize(1290, 755);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        titleLabel = new JLabel("Credit", SwingConstants.CENTER);
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 100));

        panel.add(titleLabel, BorderLayout.CENTER);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(150, 50));
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void setBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void updateTitleFont(Font font) {
        titleLabel.setFont(font);
    }

    public JFrame getFrame() {
        return this;
    }
}
