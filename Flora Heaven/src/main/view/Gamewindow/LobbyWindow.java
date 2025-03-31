package main.view.Gamewindow;

import main.controller.LobbyController;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import main.view.Lobby.*;

public class LobbyWindow extends JFrame {
    public static final int TRANSITION_NONE = 0;
    public static final int TRANSITION_FADE = 1;
    public static final int TRANSITION_ZOOM = 2;
    public static final int TRANSITION_SLIDE = 3;
    
    private GameboardPanel gameboardpanel;
    private LobbybackgroundPanel lobbybackgroundpanel;
    private startBtnPanel startbtnpanel;
    private quitBtnPanel quitbtnpanel;
    private creditsBtnPanel creditsbtnpanel;
    private FireflysPanel fireflysPanel;
    private LobbyController controller;
    
    private int currentTransition = TRANSITION_NONE;
    private float transitionAlpha = 0f;
    private float zoomFactor = 1.0f;
    private float slideOffset = 0f;
    private BufferedImage transitionBuffer;
    private Timer animationTimer;

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
                renderTransitionEffect(g);
            }
        };
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        layeredPane.add(lobbybackgroundpanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(fireflysPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(gameboardpanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(startbtnpanel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(quitbtnpanel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(creditsbtnpanel, JLayeredPane.POPUP_LAYER);

        add(layeredPane);
    }

    private void setupAnimationTimer() {
        animationTimer = new Timer(16, e -> {
            controller.updateFireflies(getWidth(), getHeight());
            repaint();
        });
        animationTimer.start();
    }

    public void setTransitionType(int type) {
        this.currentTransition = type;
    }
    
    public void setTransitionAlpha(float alpha) {
        this.transitionAlpha = Math.min(1f, Math.max(0f, alpha));
        repaint();
    }
    
    public void setZoomFactor(float factor) {
        this.zoomFactor = factor;
        repaint();
    }
    
    public void setSlideOffset(float offset) {
        this.slideOffset = offset;
        repaint();
    }

    private void renderTransitionEffect(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        switch(currentTransition) {
            case TRANSITION_ZOOM:
                AffineTransform transform = new AffineTransform();
                transform.translate(getWidth()/2, getHeight()/2);
                transform.scale(zoomFactor, zoomFactor);
                transform.translate(-getWidth()/2, -getHeight()/2);
                g2d.setTransform(transform);
                break;
                
            case TRANSITION_SLIDE:
                g2d.translate(-slideOffset * getWidth(), 0);
                break;
        }
        
        if (transitionAlpha > 0) {
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, transitionAlpha));
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    @Override
    public void paint(Graphics g) {
        if (transitionBuffer == null || 
            transitionBuffer.getWidth() != getWidth() || 
            transitionBuffer.getHeight() != getHeight()) {
            transitionBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }
        
        Graphics bufferGraphics = transitionBuffer.getGraphics();
        super.paint(bufferGraphics);
        bufferGraphics.dispose();
        
        Graphics2D g2d = (Graphics2D) g;
        renderTransitionEffect(g2d);
        g2d.drawImage(transitionBuffer, 0, 0, null);
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
        if (transitionBuffer != null) {
            transitionBuffer.flush();
        }
        super.dispose();
    }
}