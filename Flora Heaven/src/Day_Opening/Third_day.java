package Day_Opening;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Third_day extends JFrame {
    private Timer closeTimer;

    public Third_day() {
        setTitle("Flora Heaven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1290, 755);

        Start_day backgroundPanel = new Start_day();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1728, 960));

        backgroundPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        addTextLabels(layeredPane);

        add(layeredPane,BorderLayout.CENTER);
        setLocationRelativeTo(null); 

       setupCloseTimer();
    }

    private void addTextLabels(JLayeredPane layeredPane) {
        JLabel titleLabel = new JLabel("Day 3", SwingConstants.CENTER);
        titleLabel.setFont(new Font("TH Sarabun New", Font.BOLD, 96)); // can change font and size
        titleLabel.setForeground(new Color(54, 32, 19));
        titleLabel.setBounds(620, 280, 190, 60); 
        
        JLabel subtitleLabel = new JLabel("แสงที่อาจเป็นภาพลวงตา", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("TH Sarabun New", Font.PLAIN, 56)); // can change font and size
        subtitleLabel.setForeground(new Color(54, 32, 19));
        subtitleLabel.setBounds(525, 370, 370, 70);

        layeredPane.add(titleLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(subtitleLabel, JLayeredPane.PALETTE_LAYER);
    }

    private void setupCloseTimer() {
        closeTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeTimer.stop();
                dispose(); // can change to story day 3
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