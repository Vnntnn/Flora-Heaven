package controller;

import model.Firefly;
import view.Gamewindow.LobbyWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
        view.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start button clicked!");
            }
        });

        view.getCreditsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Credits button clicked!");
            }
        });

        view.getQuitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public ArrayList<Firefly> getFireflies() {
        return fireflies;
    }
}
