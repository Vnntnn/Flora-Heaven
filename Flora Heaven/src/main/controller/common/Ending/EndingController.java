package main.controller.common.Ending;

import main.controller.lobby.LobbyController;
import main.model.Gameplay.StoryHandler;
import main.view.Gamewindow.Ending.EndingView;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Map;

public class EndingController {
    private EndingView view;
    private Font customFont;
    private Image backgroundImage;
    private StoryHandler storyHandler;

    public EndingController(StoryHandler storyHandler) {
        this.storyHandler = storyHandler;
        EventQueue.invokeLater(() -> {
            try {
                initialize();
            } catch (Exception e) {
                handleResourceError(e);
            }
        });
    }

    public EndingController() {
        this(new DefaultStoryHandler());
    }

    private void initialize() throws IOException, FontFormatException {
        loadResources();
        Map<String, EndingView.StoryLabelInfo> labelInfos = storyHandler.createStoryContent();
        view = new EndingView(customFont, backgroundImage, labelInfos);
        setupEventListeners();
        view.show();
    }

    private void loadResources() throws IOException, FontFormatException {
        customFont = loadFont("/assets/Font/Pixelpoint.ttf");
        backgroundImage = loadBackgroundImage("/assets/img/bgEnd.png");
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
            EventQueue.invokeLater(() -> new LobbyController());
        });
    }

    private void handleResourceError(Exception e) {
        System.err.println("Error loading resources: " + e.getMessage());
        e.printStackTrace();
        
        EventQueue.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, 
                "Failed to load game resources:\n" + e.getMessage(), 
                "Resource Loading Error", 
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
}