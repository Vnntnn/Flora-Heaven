package main.controller.common;

import main.model.Player.Player;
import main.view.Gamewindow.Ending.SecretView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SecretController {
    private SecretView view;
    private Font customFont;
    private Image backgroundImage;
    private Player player;

    public SecretController(Player player) {
        this.player = player;
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
        Map<String, SecretView.StoryLabelInfo> labelInfos = createLabelInfos();
        view = new SecretView(customFont, backgroundImage, labelInfos);
        setupEventListeners();
        view.show();
    }

    private void loadResources() throws IOException, FontFormatException {
        customFont = loadFont("/assets/Font/Pixelpoint.ttf");
        backgroundImage = loadBackgroundImage("/assets/secret/bgSecret.png");
    }

    private Map<String, SecretView.StoryLabelInfo> createLabelInfos() {
        Map<String, SecretView.StoryLabelInfo> labelInfos = new HashMap<>();
        int width = 1290;
        
        // Title and subtitle
        labelInfos.put("title", new SecretView.StoryLabelInfo(
            "โครงการทดลองลับ :", 30f, 140, 5, width, 200));
        
        labelInfos.put("subtitle", new SecretView.StoryLabelInfo(
            "Flora Heaven", 50f, 145, 50, width, 200));
        
        // Main story
        labelInfos.put("story", new SecretView.StoryLabelInfo(
            "เราใช้พืชเหล่านี้เพื่อควบคุมอารมณ์ ความคิด และร่างกายของมนุษย์", 
            25f, 140, 200, width, 200));
        
        // Tree descriptions
        labelInfos.put("tree1", new SecretView.StoryLabelInfo(
            "หมายเลข 1: Heartroot - ควบคุมหัวใจ", 
            23f, 160, 270, width, 200));
        
        labelInfos.put("tree2", new SecretView.StoryLabelInfo(
            "หมายเลข 4: Illumis Sprout - กระตุ้นการมองเห็น สร้างภาพลวงตา", 
            23f, 160, 320, width, 200));
        
        labelInfos.put("tree3", new SecretView.StoryLabelInfo(
            "หมายเลข 7: Silentis Shade - ลดเสียง แต่ทำให้เกิดคลื่นกระซิบในสมอง", 
            23f, 160, 370, width, 200));
        
        labelInfos.put("tree4", new SecretView.StoryLabelInfo(
            "หมายเลข 13: Huolu - เร่งเผาผลาญพลังงานจนร่างกายร้อนเกินไป",
            23f, 160, 420, width, 200));
        
        // Ending
        labelInfos.put("ending", new SecretView.StoryLabelInfo(
            "...โครงการนี้ถูกยกเลิก และนักวิจัยทั้งหมดถูกทำให้ เงียบ ไปแล้ว...", 
            25f, 140, 500, width, 200));
        
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
        return icon.getImage().getScaledInstance(1290, 755, Image.SCALE_SMOOTH);
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
            EventQueue.invokeLater(() ->  new EndingController());
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
