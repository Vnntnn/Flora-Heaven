package main.view.AssetsLoader.gameplay.Arcanashop;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubQuestTextPanel extends JPanel{
    private JLabel hintJLabel1,hintJLabel2,hintJLabel3;
    public SubQuestTextPanel(){
        hintJLabel1 = new JLabel("ข้าต้องการต้นไม้ที่");
        hintJLabel2 = new JLabel("LuckBloom");
        hintJLabel3 = new JLabel("Bloodvalor");
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
            Font sizedFont = customFont.deriveFont(Font.BOLD, 10f);
            hintJLabel1.setFont(sizedFont);
            hintJLabel2.setFont(sizedFont);
            hintJLabel3.setFont(sizedFont);
        }
        catch (Exception e){
            e.printStackTrace();
            hintJLabel1.setFont(new Font("Leelawadee UI", Font.BOLD, 12)); // Fallback font
            hintJLabel2.setFont(new Font("Leelawadee UI", Font.BOLD, 12));
            hintJLabel3.setFont(new Font("Leelawadee UI", Font.BOLD, 12));
        }
        add(hintJLabel1);
        add(hintJLabel2);
        add(hintJLabel3);
    }
    public JLabel getHintJLabel3() {
        return hintJLabel3;
    }
    public JLabel getHintJLabel2() {
        return hintJLabel2;
    }
    public JLabel getHintJLabel1() {
        return hintJLabel1;
    }
    

    
}
