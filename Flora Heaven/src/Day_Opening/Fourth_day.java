package Day_Opening;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fourth_day extends JFrame {
    private Timer closeTimer;
    // Timer 5 sec
    public Fourth_day() {
        setTitle("Flora Heaven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1290, 755);

        Fourth_day_img backgroundPanel = new Fourth_day_img();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1728, 960));

        backgroundPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        add(layeredPane,BorderLayout.CENTER);
        setLocationRelativeTo(null); 

        setupCloseTimer();
    }


    private void setupCloseTimer() {
        closeTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeTimer.stop();
                dispose(); // can change to story day 4
            }
        });
        closeTimer.setRepeats(false);
        closeTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Fourth_day frame = new Fourth_day();
            frame.setVisible(true);
        });
    }
}