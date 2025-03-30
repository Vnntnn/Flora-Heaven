package main.view.trees;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class Bloodvalor_blossomPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.bloodvalorblossom, 0, 0, getWidth(), getHeight(), this);
    }
/* 
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setLayout(null);
        JPanel p = new Bloodvalor_blossomPanel();
        p.setBounds(0, 0, 80, 80);
        fr.add(p);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1290,755);
        fr.setVisible(true);
    }*/
}