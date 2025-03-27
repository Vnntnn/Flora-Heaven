package Day_Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Third_day extends JFrame {
    private Timer closeTimer;
    // Timer 7 sec
    public Third_day() {
        setTitle("Flora Heaven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1290, 755);

        Third_day_img backgroundPanel = new Third_day_img();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1728, 960));

        backgroundPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        add(layeredPane,BorderLayout.CENTER);
        setLocationRelativeTo(null); 

        setupCloseTimer();
    }

    private void setupCloseTimer() {
        closeTimer = new Timer(7000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeTimer.stop();
                dispose();
            }
        });
        closeTimer.setRepeats(false);
        closeTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Third_day frame = new Third_day();
            frame.setVisible(true);
        });
    }
}