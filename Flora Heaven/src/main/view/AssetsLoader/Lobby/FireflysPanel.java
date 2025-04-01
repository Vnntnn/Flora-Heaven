package main.view.AssetsLoader.Lobby;

/*
  @author tipwareeetaokhotsee
*/

import main.controller.lobby.LobbyController;
import main.model.Threads.Firefly;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FireflysPanel extends JPanel {
    private LobbyController controller;

    public FireflysPanel(LobbyController controller) {
        this.controller = controller;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        ArrayList<Firefly> fireflies = controller.getFireflies();
        for (Firefly firefly : fireflies) {
            firefly.draw(g2d);
        }
    }
}