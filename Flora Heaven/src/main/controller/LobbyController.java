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
        startSmoothTransition(() -> {
            new OpenStoryController().show();
        }, LobbyWindow.TRANSITION_SLIDE);
    }
    
    private void handleCreditsButton() {
        setButtonsEnabled(false);
        startSmoothTransition(() -> {
            new CreditController(this).show();
        }, LobbyWindow.TRANSITION_SLIDE);
    }
    
    private void handleQuitButton() {
        setButtonsEnabled(false);
        startSmoothTransition(() -> {
            new QuitController(this).show();
        }, LobbyWindow.TRANSITION_ZOOM); 
    }
    
    private void startSmoothTransition(Runnable onComplete, int transitionType) {
        // หยุด timer ถ้ายังทำงานอยู่
        if (transitionTimer != null && transitionTimer.isRunning()) {
            transitionTimer.stop();
        }
        
        // ตั้งค่าประเภท transition
        view.setTransitionType(transitionType);
        
        // สร้าง timer สำหรับ animation
        transitionTimer = new Timer(16, new ActionListener() {
            private float progress = 0f;
            private final float speed = 0.05f; 
            
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += speed;
                
                if (progress >= 1.0f) {
                    progress = 1.0f;
                    ((Timer)e.getSource()).stop();
                    
                    // เมื่อ animation เสร็จสิ้น
                    SwingUtilities.invokeLater(() -> {
                        if (view != null) {
                            view.dispose();
                        }
                        onComplete.run();
                    });
                }
                
                // อัพเดต transition ตามประเภท
                switch(transitionType) {
                    case LobbyWindow.TRANSITION_FADE:
                        view.setTransitionAlpha(progress);
                        break;
                        
                    case LobbyWindow.TRANSITION_ZOOM:
                        view.setZoomFactor(1.0f - progress * 0.9f); // zoom จาก 1.0 ถึง 0.1
                        break;
                        
                    case LobbyWindow.TRANSITION_SLIDE:
                        view.setSlideOffset(progress);
                        break;
                }
            }
        });
        transitionTimer.start();
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