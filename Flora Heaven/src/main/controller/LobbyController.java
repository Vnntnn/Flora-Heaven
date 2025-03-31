package main.controller;

/*
  @author tipwareeetaokhotsee
*/

import main.view.Gamewindow.LobbyWindow;
import main.model.Threads.Firefly;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class LobbyController {
    private LobbyWindow view;
    private final ArrayList<Firefly> fireflies;
    private static final int NUM_FIREFLIES = 120;
    private boolean isViewReady = false; // เพิ่ม flag ตรวจสอบ

    public LobbyController() {
        this.fireflies = new ArrayList<>();
        initFireflies();
        this.view = new LobbyWindow(this);
        this.isViewReady = true; // ตั้งค่าเมื่อ view พร้อม
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
        if (!isViewReady || view == null) return;

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

    public static void main(String[] args) {
        new LobbyController();
    }
}