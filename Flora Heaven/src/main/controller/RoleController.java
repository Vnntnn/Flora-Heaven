package main.controller;

import main.view.Role.RoleView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoleController {
    private RoleView view;
    private Font customFont;
    private Image backgroundImage;

    public RoleController() {
        EventQueue.invokeLater(() -> {
            try {
                initialize();
            } catch (Exception e) {
                handleResourceError(e);
            }
        });
    }

    private void initialize() throws IOException, FontFormatException {
        loadResources();
        view = new RoleView(customFont, backgroundImage);
        setupEventListeners();
        view.show();
    }

    public RoleView getView() {
        return this.view; 
    }
    

    private void loadResources() throws IOException, FontFormatException {
        customFont = loadFont("/assets/Font/Pixelpoint.ttf");
        backgroundImage = loadBackgroundImage("/assets/img/bgRole.png");
    }

    private Font loadFont(String path) throws IOException, FontFormatException {
        try (InputStream fontStream = getClass().getResourceAsStream(path)) {
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found: " + path);
            }
            return Font.createFont(Font.TRUETYPE_FONT, fontStream);
        }
    }

    private Image loadBackgroundImage(String path) throws IOException {
        URL imageUrl = getClass().getResource(path);
        if (imageUrl == null) {
            throw new FileNotFoundException("Background image not found: " + path);
        }
        ImageIcon icon = new ImageIcon(imageUrl);
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            throw new IOException("Failed to load image: " + path);
        }
        return icon.getImage();
    }

    private void setupEventListeners() {
        if (view == null) {
            throw new IllegalStateException("View is not initialized");
        }

        JButton nextButton = view.getNextButton();
        if (nextButton == null) {
            throw new IllegalStateException("Next button is null. View not properly initialized.");
        }
        
        nextButton.addActionListener(e -> {
            view.close();
            EventQueue.invokeLater(() -> new EndingController());
        });
    }

    private void handleResourceError(Exception e) {
        System.err.println("Error loading resources: " + e.getMessage());
        e.printStackTrace();
        
        EventQueue.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, 
                "Failed to load application resources.\nError: " + e.getMessage(),
                "Critical Error", 
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        });
    }

    public void dispose() {
        if (view != null) {
            view.close();
        }
        backgroundImage = null;
        customFont = null;
    }

    public void fadeOut(JFrame frame, Runnable onComplete) {
        Timer timer = new Timer(30, new ActionListener() {
            private float opacity = 1f;
    
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.05f;
                if (opacity <= 0) {
                    opacity = 0;
                    ((Timer) e.getSource()).stop();
                    SwingUtilities.invokeLater(() -> {
                        frame.setVisible(false);
                        onComplete.run();
                    });
                }
                frame.setOpacity(opacity);
            }
        });
        timer.start();
    }

    // ฟังก์ชัน Fade In
    public void fadeIn(JFrame frame) {
        SwingUtilities.invokeLater(() -> {
            frame.setUndecorated(true);
            frame.setOpacity(0f);
            frame.setVisible(true);
        });

        Timer timer = new Timer(30, new ActionListener() {
            private float opacity = 0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += 0.05f;
                if (opacity >= 1) {
                    opacity = 1;
                    ((Timer) e.getSource()).stop();
                }
                frame.setOpacity(opacity);
            }
        });
        timer.start();
    }

    public void show() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }
}