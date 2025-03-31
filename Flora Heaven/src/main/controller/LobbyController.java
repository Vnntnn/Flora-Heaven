package main.controller;

import main.view.Gamewindow.LobbyWindow;
import main.model.Threads.Firefly;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class LobbyController {
    private LobbyWindow view;
    private ArrayList<Firefly> fireflies;
    private static final int NUM_FIREFLIES = 120;
    public Timer transitionTimer;

    public LobbyController() {
        this.fireflies = new ArrayList<>();
        initFireflies();
        this.view = new LobbyWindow(this);
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
        SwingUtilities.invokeLater(view::repaint);
    }

    private void addEventListeners() {
        JButton startButton = view.getStartButton();
        JButton creditsButton = view.getCreditsButton();
        JButton quitButton = view.getQuitButton();

        if (startButton != null) {
            startButton.addActionListener(e -> handleStartButton());
        }
        
        if (creditsButton != null) {
            creditsButton.addActionListener(e -> handleCreditsButton());
        }
        
        if (quitButton != null) {
            quitButton.addActionListener(e -> handleQuitButton());
        }
    }

    private void handleStartButton() {
        setButtonsEnabled(false);
        startInstantTransition(() -> {
            view.dispose();
            new OpenStoryController().show();
        });
    }
    
    private void handleCreditsButton() {
        setButtonsEnabled(false);
        startInstantTransition(() -> {
            view.dispose();
            new CreditController(this).show();
        });
    }
    
    private void handleQuitButton() {
        setButtonsEnabled(false);
        startInstantTransition(() -> {
            view.dispose();
            new QuitController(this).show();
        });
    }
    
    private void startInstantTransition(Runnable onComplete) {
        if (transitionTimer != null && transitionTimer.isRunning()) {
            transitionTimer.stop();
        }
        
        SwingUtilities.invokeLater(() -> {
            if (view != null) {
                view.dispose();
            }
            onComplete.run();
        });
    }

    private void setButtonsEnabled(boolean enabled) {
        if (view.getStartButton() != null) 
            view.getStartButton().setEnabled(enabled);
        if (view.getCreditsButton() != null) 
            view.getCreditsButton().setEnabled(enabled);
        if (view.getQuitButton() != null) 
            view.getQuitButton().setEnabled(enabled);
    }

    public ArrayList<Firefly> getFireflies() {
        return fireflies;
    }
}