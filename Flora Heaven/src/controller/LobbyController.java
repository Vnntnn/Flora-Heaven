package controller;

/*
  @author tipwareeetaokhotsee
*/

import model.Firefly;
import view.Gamewindow.LobbyWindow;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class LobbyController {
    private LobbyWindow view;
    private ArrayList<Firefly> fireflies;
    private static final int NUM_FIREFLIES = 120;

    public LobbyController() {
        this.view = new LobbyWindow(this);
        this.fireflies = new ArrayList<>();
        initFireflies();
        addEventListeners();
    }

    public LobbyWindow getView() {
        return view;
    }

    public LobbyController getController() {
        return this;
    }

    private void initFireflies() {
        Random rand = new Random();
        for (int i = 0; i < NUM_FIREFLIES; i++) {
            fireflies.add(new Firefly(rand.nextInt(1290), rand.nextInt(755), 1290, 755));
        }
    }

    public void updateFireflies(int width, int height) {
        for (Firefly firefly : fireflies) {
            firefly.move();
        }
        view.repaint();
    }

    private void addEventListeners() {
        JButton startButton = view.getStartButton();
        JButton creditsButton = view.getCreditsButton();
        JButton quitButton = view.getQuitButton();

        if (startButton != null) {
            startButton.addActionListener(e -> {
                view.setVisible(false);
                new openStoryPage();
            });
        }

        if (creditsButton != null) {
            creditsButton.addActionListener(e -> {
                view.setVisible(false);
                new creditPage();
            });
        }

        if (quitButton != null) {
            quitButton.addActionListener(e -> {
                System.exit(0);
            });
        }
    }

    public ArrayList<Firefly> getFireflies() {
        return fireflies;
    }
}