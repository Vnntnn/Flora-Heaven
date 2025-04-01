package main.controller.common;

import main.controller.lobby.LobbyController;
import main.view.Gamewindow.common.QuitView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

public class QuitController {
    private QuitView view;
    private LobbyController lobbyController;

    public QuitController(LobbyController lobbyController) {
        this.lobbyController = lobbyController;
        initialize();
    }

    private void initialize() {
        try {
            // Load resources
            Font customFont = loadFont("/assets/Font/Pixelpoint.ttf");
            Image background = loadBackgroundImage("/assets/img/bg1.png");

            // Initialize view
            view = new QuitView(customFont, background);
            
            // Set up event listeners
            setupEventListeners();
            
            view.show();
        } catch (IOException | FontFormatException e) {
            handleResourceError(e);
        }
    }

    public void show() {
        EventQueue.invokeLater(() -> {
            if (view != null) {
                view.setVisible(true);
                view.toFront();
            }
        });
    }
    private Font loadFont(String path) throws IOException, FontFormatException {
        try (InputStream fontStream = getClass().getResourceAsStream(path)) {
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found: " + path);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            return font;
        }
    }

    private Image loadBackgroundImage(String path) throws IOException {
        URL imageUrl = getClass().getResource(path);
        if (imageUrl == null) {
            throw new FileNotFoundException("Background image not found: " + path);
        }
        return new ImageIcon(imageUrl).getImage();
    }

    private void setupEventListeners() {
        view.getYesButton().addActionListener(e -> {
            System.exit(0);
        });
    
        view.getNoButton().addActionListener(e -> {
            // ปิดหน้าต่าง Quit ก่อน
            view.close();
            
            // เปิด Lobby ใหม่แบบปลอดภัย
            SwingUtilities.invokeLater(() -> {
                if (lobbyController != null) {
                    EventQueue.invokeLater(() -> new LobbyController());
                }
            });
        });
    }

    private void handleResourceError(Exception e) {
        System.err.println("Error loading resources: " + e.getMessage());
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,
            "Failed to load resources: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}