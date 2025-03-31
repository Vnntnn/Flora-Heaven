package main.view.Gamewindow;

import main.controller.LobbyController;
import main.view.Lobby.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

public class LobbyWindow extends JFrame {
    private GameboardPanel gameboardpanel;
    private LobbybackgroundPanel lobbybackgroundpanel;
    private startBtnPanel startbtnpanel;
    private quitBtnPanel quitbtnpanel;
    private creditsBtnPanel creditsbtnpanel;
    private FireflysPanel fireflysPanel;
    private LobbyController controller;
    
    // Transition effects
    private float transitionAlpha = 0f;
    private float zoomFactor = 1.0f;
    private float slideOffset = 0f;
    private BufferedImage transitionBuffer;
    private Timer animationTimer;
    
    // Transition types
    public static final int TRANSITION_FADE = 0;
    public static final int TRANSITION_ZOOM = 1;
    public static final int TRANSITION_SLIDE = 2;
    private int currentTransition = TRANSITION_FADE;

    public LobbyWindow(LobbyController controller) {
        this.controller = controller;
            initializeWindow();
            initializePanels();
            setupLayeredPane();
            setupAnimationTimer();
            setVisible(true);
        
    }

    private void initializeWindow() {
        setTitle("Flora Heaven");
        setSize(1290, 755);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(false);
    }

    private void initializePanels() {
        lobbybackgroundpanel = new LobbybackgroundPanel();
        gameboardpanel = new GameboardPanel();
        startbtnpanel = new startBtnPanel();
        quitbtnpanel = new quitBtnPanel();
        creditsbtnpanel = new creditsBtnPanel();
        fireflysPanel = new FireflysPanel(controller);

        Rectangle bounds = new Rectangle(0, 0, 1290, 755);
        lobbybackgroundpanel.setBounds(bounds);
        gameboardpanel.setBounds(bounds);
        startbtnpanel.setBounds(bounds);
        quitbtnpanel.setBounds(bounds);
        creditsbtnpanel.setBounds(bounds);
        fireflysPanel.setBounds(bounds);

        gameboardpanel.setOpaque(false);
        startbtnpanel.setOpaque(false);
        quitbtnpanel.setOpaque(false);
        creditsbtnpanel.setOpaque(false);
        fireflysPanel.setOpaque(false);
    }

    private void setupLayeredPane() {
        JLayeredPane layeredPane = new JLayeredPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                paintTransitionEffect(g);
            }
        };
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        layeredPane.add(lobbybackgroundpanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(gameboardpanel, Integer.valueOf(1));
        layeredPane.add(fireflysPanel, Integer.valueOf(2));
        layeredPane.add(startbtnpanel, Integer.valueOf(3));
        layeredPane.add(quitbtnpanel, Integer.valueOf(3));
        layeredPane.add(creditsbtnpanel, Integer.valueOf(3));

        add(layeredPane);
    }

    private void setupAnimationTimer() {
        animationTimer = new Timer(16, e -> {
            controller.updateFireflies(getWidth(), getHeight());
            repaint();
        });
        animationTimer.start();
    }

    // Transition control methods
    public void setTransitionType(int type) {
        this.currentTransition = type;
    }
    
    public void setTransitionAlpha(float alpha) {
        this.transitionAlpha = Math.min(1f, Math.max(0f, alpha));
    }
    
    public void setZoomFactor(float factor) {
        this.zoomFactor = factor;
    }
    
    public void setSlideOffset(float offset) {
        this.slideOffset = offset;
    }

    private void paintTransitionEffect(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        
        try {
            // Apply current transition effect
            switch(currentTransition) {
                case TRANSITION_ZOOM:
                    AffineTransform transform = new AffineTransform();
                    transform.translate(getWidth()/2, getHeight()/2);
                    transform.scale(zoomFactor, zoomFactor);
                    transform.translate(-getWidth()/2, -getHeight()/2);
                    g2d.setTransform(transform);
                    break;
                    
                case TRANSITION_SLIDE:
                    g2d.translate(slideOffset * getWidth(), 0);
                    break;
            }
            
            // Always apply fade overlay
            if (transitionAlpha > 0) {
                g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, transitionAlpha));
                g2d.setColor(Color.BLACK);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        } finally {
            g2d.dispose();
        }
    }

    @Override
    public void paint(Graphics g) {
        // Double buffering with transition effects
        if (transitionBuffer == null || 
            transitionBuffer.getWidth() != getWidth() || 
            transitionBuffer.getHeight() != getHeight()) {
            transitionBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }
        
        Graphics bufferGraphics = transitionBuffer.getGraphics();
        super.paint(bufferGraphics);
        
        Graphics2D g2d = (Graphics2D) g;
        
        // Apply transition effects to final render
        switch(currentTransition) {
            case TRANSITION_ZOOM:
                AffineTransform transform = new AffineTransform();
                transform.translate(getWidth()/2, getHeight()/2);
                transform.scale(zoomFactor, zoomFactor);
                transform.translate(-getWidth()/2, -getHeight()/2);
                g2d.setTransform(transform);
                break;
                
            case TRANSITION_SLIDE:
                g2d.translate(slideOffset * getWidth(), 0);
                break;
        }
        
        g2d.drawImage(transitionBuffer, 0, 0, null);
        
        // Apply fade overlay
        if (transitionAlpha > 0) {
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, transitionAlpha));
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
        
        bufferGraphics.dispose();
        g2d.dispose();
    }

    public JButton getStartButton() {
        return startbtnpanel.getStartBtn();
    }

    public JButton getCreditsButton() {
        return creditsbtnpanel.getCreditseButton();
    }

    public JButton getQuitButton() {
        return quitbtnpanel.getQuitBtn();
    }
    
    @Override
    public void dispose() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
        super.dispose();
    }
}