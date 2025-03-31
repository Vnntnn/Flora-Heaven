package main.controller;

import main.model.Player.Player;
import main.view.Fail.FailView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FailController {
    private FailView view;
    private Font customFont;
    private Image backgroundImage;
    private Player player;

    public FailController(Player player) {
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
        Map<String, FailView.StoryLabelInfo> labelInfos = createLabelInfos();
        view = new FailView(customFont, backgroundImage, labelInfos);
        setupEventListeners();
        view.show();
    }

    private void loadResources() throws IOException, FontFormatException {
        customFont = loadFont("/assets/Font/Pixelpoint.ttf");
        backgroundImage = loadBackgroundImage("/assets/img/bgStory.png");
    }

    private Map<String, FailView.StoryLabelInfo> createLabelInfos() {
        Map<String, FailView.StoryLabelInfo> labelInfos = new HashMap<>();
        int width = 1290;
        
        // Title
        labelInfos.put("title", new FailView.StoryLabelInfo(
            "Failed", 80f, 540, 22, width, 200));
        
        // Story content
        labelInfos.put("story1", new FailView.StoryLabelInfo(
            "หลังจากที่คุุณตอบรับคำขอในจดหมายฉบับสุดท้าย คุณบอกลาเหล่าต้นไม้ที่อยู่กับคุณมาทั้งวันเพื่อขอตัวไปพักผ่อน", 
            18f, 150, 150, width, 200));
        
        labelInfos.put("story2", new FailView.StoryLabelInfo(
            "พวกมันนิ่งเงียบไม่ตอบอะไรเหมือนทุกที คงเป็นอีกวันที่คุณยืนถอนหายใจด้วยความเหนื่อยล้าอยู่หน้ากระจกบานเก่า", 
            18f, 100, 200, width, 200));
        
        labelInfos.put("story3", new FailView.StoryLabelInfo(
            "คุณได้แต่ยืนจ้องมองคนในกระจก ภาพสะท้อนที่คุณควรคุ้นเคยกับมันมากกว่าใครๆ แต่คุณกลับจำอะไรไม่ได้เลย— ", 
            18f, 100, 250, width, 200));
        
        labelInfos.put("story4", new FailView.StoryLabelInfo(
            "คุณพยายามนึก พยายามไขว่คว้าความทรงจำที่ควรเป็นของตัวเอง แต่ยิ่งพยายามจับมันไว้ ทุกอย่างกลับยิ่งเลือนหาย", 
            18f, 100, 320, width, 200));
        
        labelInfos.put("story5", new FailView.StoryLabelInfo(
            "หัวใจเต้นช้าลง ความคิดพร่าเลือน คุณเริ่มหลงลืมแม้กระทั่งว่ากำลังพยายามนึกถึงอะไร —แล้วทุกอย่างก็ดับลง", 
            18f, 100, 370, width, 200));
        
        // Ending tag
        labelInfos.put("ending", new FailView.StoryLabelInfo(
            "ENDING (?): ภาพสะท้อนที่ว่างเปล่า", 
            25f, 430, 470, width, 200));
        
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
            EventQueue.invokeLater(() -> new SecretController(player));
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