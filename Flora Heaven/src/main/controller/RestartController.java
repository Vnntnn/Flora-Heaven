package main.controller;

import main.view.Restart.RestartView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RestartController {
    private RestartView view;
    private Font customFont;
    private Image backgroundImage;
    private Image yesButtonImage;
    private Image noButtonImage;

    public RestartController() {
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
        Map<String, RestartView.LabelInfo> labelInfos = createLabelInfos();
        view = new RestartView(customFont, backgroundImage, yesButtonImage, noButtonImage, labelInfos);
        setupEventListeners();
        view.show();
    }

    private void loadResources() throws IOException, FontFormatException {
        customFont = loadFont("/assets/Font/Pixelpoint.ttf");
        backgroundImage = loadImage("/assets/img/bgOpen.png", 1290, 755);
        yesButtonImage = loadImage("/assets/img/btnYesRe.png", 380, 120);
        noButtonImage = loadImage("/assets/img/btnNoRe.png", 320, 120);
    }

    private Map<String, RestartView.LabelInfo> createLabelInfos() {
        Map<String, RestartView.LabelInfo> labelInfos = new HashMap<>();
        int width = 1290;
        
        labelInfos.put("title", new RestartView.LabelInfo(
            "คุณได้กลิ่นอายของไม้เก่าและสมุนไพรอวลอยู่ในอากาศ เปลวเทียนไหวระริกจากสายลมแผ่วเบา",
            23f, 100, 120, width, 200));
        
        labelInfos.put("quest", new RestartView.LabelInfo(
            "วันนี้เป็นวันแรกของคุณที่นี่... ใช่ไหม?",
            28f, 380, 190, width, 200));
        
        return labelInfos;
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

    private Image loadImage(String path, int width, int height) throws IOException {
        URL imageUrl = getClass().getResource(path);
        if (imageUrl == null) {
            throw new FileNotFoundException("Image not found: " + path);
        }
        ImageIcon icon = new ImageIcon(imageUrl);
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            throw new IOException("Failed to load image: " + path);
        }
        return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    private void setupEventListeners() {
        view.getYesButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.close();
                EventQueue.invokeLater(() -> new LobbyController());
            }
        });

        view.getNoButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.close();
                EventQueue.invokeLater(() -> new SecretController());
                
            }
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
        yesButtonImage = null;
        noButtonImage = null;
    }
}