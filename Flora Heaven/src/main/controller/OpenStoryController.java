package main.controller;

import main.view.OpenStory.OpenStoryView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class OpenStoryController {
    private OpenStoryView view;
    private Font customFont;
    private Image backgroundImage;

    public OpenStoryController() {
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
        Map<String, OpenStoryView.StoryLabelInfo> labelInfos = createLabelInfos();
        view = new OpenStoryView(customFont, backgroundImage, labelInfos);
        setupEventListeners();
        view.show();
    }

    private void loadResources() throws IOException, FontFormatException {
        customFont = loadFont("/assets/Font/Pixelpoint.ttf");
        backgroundImage = loadBackgroundImage("/assets/img/bgOpen.png");
    }

    private Map<String, OpenStoryView.StoryLabelInfo> createLabelInfos() {
        Map<String, OpenStoryView.StoryLabelInfo> labelInfos = new HashMap<>();
        int width = 1290; // Assuming this is the width you used in your JLabels
        
        // ข้อมูล label ทั้งหมด
        labelInfos.put("story1", new OpenStoryView.StoryLabelInfo(
            "กลางป่าลึก บนภูเขาสูงที่ถูกปกคลุมด้วยม่านหมอกตลอดทั้งปี มีหมู่บ้านเล็ก ๆ แห่งหนึ่งที่ดูเหมือนจะ",
            18f, 200, 60, width, 200));
        
        labelInfos.put("story2", new OpenStoryView.StoryLabelInfo(
            "ถูกลืมจากแผนที่ของโลก ไม่มีหมอ ไม่มีโรงพยาบาล ไม่มีทางเข้าถึงสิ่งอำนวยความสะดวกใด ๆ จากภายนอก",
            18f, 120, 110, width, 200));
        
        labelInfos.put("story3", new OpenStoryView.StoryLabelInfo(
            "หากใครล้มป่วยหรือได้รับบาดเจ็บ พวกเขามีเพียงทางเลือกเดียว คือ ส่งจดหมายมายัง 'ร้านต้นไม้วิเศษ'",
            18f, 120, 160, width, 200));
        
        labelInfos.put("story4", new OpenStoryView.StoryLabelInfo(
            "ร้านที่ไม่มีใครเคยเห็นเจ้าของชัดเจน ไม่มีใครรู้ว่าตั้งอยู่ที่ไหนแน่ชัด รู้เพียงว่า หากจดหมายถูกส่งไป ต้นไม้ที่ต้องการ",
            18f, 120, 230, width, 200));
        
        labelInfos.put("story5", new OpenStoryView.StoryLabelInfo(
            "จะมาปรากฏตรงหน้าทุกครั้งเสมอ ต้นไม้ที่รักษาโรค บรรเทาความทุกข์ หรืออาจเปลี่ยนแปลงโชคชะตาไปตลอดกาล",
            18f, 120, 280, width, 200));
        
        labelInfos.put("story6", new OpenStoryView.StoryLabelInfo(
            "แต่ในห้าวันนี้ คำขอเริ่มแปลกประหลาดขึ้นทุกที ราวกับมีบางสิ่งซ่อนอยู่ในถ้อยคำเหล่านั้น และเมื่อถึงวันสุดท้าย",
            18f, 120, 330, width, 200));
        
        labelInfos.put("ending", new OpenStoryView.StoryLabelInfo(
            "- ทุกอย่างจะกระจ่างแจ้ง หรือ อาจมืดมนกว่าที่คิด -",
            25f, 320, 430, width, 200));
        
        return labelInfos;
    }

    private Font loadFont(String path) throws IOException, FontFormatException {
        try (InputStream fontStream = getClass().getResourceAsStream(path)) {
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found: " + path);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            return font;
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
            EventQueue.invokeLater(() -> new RoleController());
        });
    }

    private void handleResourceError(Exception e) {
        System.err.println("Error loading resources: " + e.getMessage());
        e.printStackTrace();
        
        EventQueue.invokeLater(() -> {
            JOptionPane.showMessageDialog(null,
                "Failed to load resources: " + e.getMessage(),
                "Error",
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

    public void show() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }
}