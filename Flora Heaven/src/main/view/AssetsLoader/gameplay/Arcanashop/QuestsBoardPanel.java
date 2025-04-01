package main.view.AssetsLoader.gameplay.Arcanashop;

// ***
// Author: Vnntnn
// ***

import main.model.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class QuestsBoardPanel extends JPanel {
    private Player player;

    public QuestsBoardPanel(Player player) {
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderArcanashop.questboard, 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.WHITE);
        try{
            // Load the font file from resources using ClassLoader
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("assets/Font/Pixelpoint.ttf");
            if (fontStream == null) {
                throw new IllegalArgumentException("Font file not found in resources");
            }
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            // Derive the desired font size
            Font sizedFont = customFont.deriveFont(Font.BOLD, 36f);
            g.setFont(sizedFont);
        }
        catch (Exception e){
            e.printStackTrace();
            g.setFont(new Font("Arial", Font.BOLD, 24)); // Fallback font
        }
        g.drawString(player.getCoins() + "", 1095, 112);
    }
}
