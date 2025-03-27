package Day_Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fifth_day extends JFrame {
    private Timer closeTimer;
    // Timer 7 sec
    public Fifth_day() {
        setTitle("Flora Heaven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1290, 755);

        Fifth_day_img backgroundPanel = new Fifth_day_img();
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
                dispose();
            }
        });
        closeTimer.setRepeats(false);
        closeTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Fifth_day frame = new Fifth_day();
            frame.setVisible(true);
        });
    }
}