package view.gameplay.Arcanashop;

// ***
// Author: Vnntnn
// ***

import controller.ArcanashopController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainQuestPanel extends JPanel {
    private ArcanashopController controller;

    public MainQuestPanel(ArcanashopController controller) {
        this.controller = controller;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.onMainQuestClicked(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderArcanashop.mainquest, 0, 0, getWidth(), getHeight(), this);
    }
}
