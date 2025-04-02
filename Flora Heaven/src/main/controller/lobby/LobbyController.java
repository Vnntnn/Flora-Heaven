package main.controller.lobby;

/*
  @author tipwareeetaokhotsee
*/

import main.controller.common.OpenStoryController;
import main.model.Player.Player;
import main.model.sound.bgSound;
import main.view.Gamewindow.lobby.LobbyWindow;
import main.model.Threads.Firefly;
import main.view.Gamewindow.lobby.creditPage;
import main.model.Threads.FireflyGlowing;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class LobbyController {
    private LobbyWindow view;
    private final ArrayList<Firefly> fireflies;
    private static final int NUM_FIREFLIES = 120;
    private static final int NUM_GLOWING_FIREFLIES = 10;
    private boolean isViewReady = false;
    private Player player;

    public LobbyController() {
        this.fireflies = new ArrayList<>();
        initFireflies();
        this.view = new LobbyWindow(this);
        this.isViewReady = true;
        addEventListeners();
        this.player = new Player();
        bgSound bg = new bgSound();
        // ลดเสียงเกม
        bg.decreaseVolume(16.0f);
        bg.play();
    }

    public LobbyWindow getView() {
        return view;
    }

    public LobbyController getController() {
        return this;
    }

    private void initFireflies() {
        Random rand = new Random();
        for (int i = 0; i < NUM_FIREFLIES - NUM_GLOWING_FIREFLIES; i++) {
            fireflies.add(new Firefly(rand.nextInt(1290), rand.nextInt(755), 1290, 755));
        }
        for (int i = 0; i < NUM_GLOWING_FIREFLIES; i++) {
            fireflies.add(new FireflyGlowing(rand.nextInt(1290), rand.nextInt(755), 1290, 755));
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
        if (view.getStartButton() != null) {
            view.getStartButton().addActionListener(e -> {
                view.setVisible(false);
                new OpenStoryController();
            });
        }

        if (view.getCreditsButton() != null) {
            view.getCreditsButton().addActionListener(e -> {
                view.setVisible(false);
                new CreditController(this).show();
            });
        }

        if (view.getQuitButton() != null) {
            view.getQuitButton().addActionListener(e -> System.exit(0));
        }
    }

    public ArrayList<Firefly> getFireflies() {
        return fireflies;
    }

    public static void main(String[] args) {
        new LobbyController();
    }
}
