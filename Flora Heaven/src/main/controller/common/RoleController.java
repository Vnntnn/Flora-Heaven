package main.controller.common;

import main.controller.gameplay.ArcanashopController;
import main.model.Player.Player;
import main.view.Gamewindow.lobby.RoleView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

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
            EventQueue.invokeLater(() -> new ArcanashopController(new Player()));
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
}