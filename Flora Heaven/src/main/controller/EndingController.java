package main.controller;

import main.view.EndStory.EndingView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class EndingController {
    private EndingView view;
    private Font customFont;
    private Image backgroundImage;

    public EndingController() {
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
        Map<String, EndingView.StoryLabelInfo> labelInfos = createLabelInfos();
        view = new EndingView(customFont, backgroundImage, labelInfos);
        setupEventListeners();
        view.show();
    }

    private void loadResources() throws IOException, FontFormatException {
        customFont = loadFont("/assets/Font/Pixelpoint.ttf");
        backgroundImage = loadBackgroundImage("/assets/img/bgEnd.png");
    }

    private Map<String, EndingView.StoryLabelInfo> createLabelInfos() {
        Map<String, EndingView.StoryLabelInfo> labelInfos = new HashMap<>();
        int width = 1290; // Assuming consistent width as before
        
        // Title
        labelInfos.put("title", new EndingView.StoryLabelInfo(
            "Ending", 80f, 515, 18, width, 200));
        
        // Story content
        labelInfos.put("story1", new EndingView.StoryLabelInfo(
            "เสียงกระซิบดังขึ้นจากทุกมุมของร้าน รากไม้เริ่มขยับ กลิ่นหอมเปลี่ยนเป็นกลิ่นดินชื้น",
            18f, 150, 150, width, 200));
        
        labelInfos.put("story2", new EndingView.StoryLabelInfo(
            "และเลือดจาง ๆ คุณจ้องมองจดหมายฉบับสุดท้าย ความทรงจำที่ถูกลืมค่อยๆย้อนกลับมา",
            18f, 80, 200, width, 200));
        
        labelInfos.put("story3", new EndingView.StoryLabelInfo(
            "คุณไม่ใช่แค่เจ้าของร้านต้นไม้ คุณคือหนึ่งในนักวิจัยของโครงการ Flora Heaven",
            18f, 80, 260, width, 200));
        
        labelInfos.put("story4", new EndingView.StoryLabelInfo(
            "และลูกค้าของคุณ คือ เหยื่อที่รอดชีวิตจากมัน",
            18f, 80, 310, width, 200));
        
        labelInfos.put("story5", new EndingView.StoryLabelInfo(
            "หญิงชราลึกลับไม่ได้เป็นเพียงลูกค้าคนสุดท้าย แต่คือตัวคุณเอง เงาที่คุณหลบหนีมาตลอด",
            18f, 80, 370, width, 200));
        
        labelInfos.put("story6", new EndingView.StoryLabelInfo(
            "คุณจำได้แล้วว่าเคยจากที่ไหนมาและรู้ว่าถึงเวลาต้องเลือก จะอยู่ต่อ หรือ กลับไปเผชิญความจริง?",
            18f, 80, 420, width, 200));
        
        // Ending tag
        labelInfos.put("ending", new EndingView.StoryLabelInfo(
            "ENDING (?): ความทรงจำที่ถูกฝัง",
            25f, 430, 500, width, 200));
        
        // Notes (positioned on the right side)
        labelInfos.put("note1", new EndingView.StoryLabelInfo(
            "เราทุกคนกำลังรอเจ้าอยู่…",
            15f, 1000, 220, width, 200));
        
        labelInfos.put("note2", new EndingView.StoryLabelInfo(
            "กลับมาเถิด",
            15f, 1050, 260, width, 200));
        
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
            // อาจเปลี่ยนไปหน้า Credits หรือ MainMenu ตามต้องการ
            EventQueue.invokeLater(() -> new FailController());
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