package main.view.Restart;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;


public class restartPage{
    private JFrame fr;
    private JPanel pTopage, pTop, pMain, pMid, pBG;
    private JLayeredPane pFrame;
    private JLabel title,quest, bgLabel, btnNo, btnYes;
    private ImageIcon background;

    public restartPage() {
        //set size screen
        int width = 1290;
        int height = 755;
        
        fr = new JFrame("Flora Heaven");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(new Dimension(width, height));
        fr.setResizable(false);
        
        try {
            InputStream fontStream = restartPage.class.getResourceAsStream("/assets/Font/Pixelpoint.ttf");
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found in resources: /assets/Font/Pixelpoint.ttf");
            }
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            System.out.println("Font loaded successfully!");

            URL bgUrl = restartPage.class.getResource("/assets/img/bgOpen.png"); 
            if (bgUrl == null) {
                throw new FileNotFoundException("Background image not found: /assets/img/bgOpen.png");
            }
            ImageIcon unscaledIcon = new ImageIcon(bgUrl);
            Image scaledImage = unscaledIcon.getImage().getScaledInstance(1280, 725, Image.SCALE_DEFAULT);
            background = new ImageIcon(scaledImage);

            bgLabel = new JLabel(background);
            bgLabel.setBounds(-10, -20, width, height);
            
            pBG = new JPanel(null);
            pBG.setBounds(0, 0, width, height);
            pBG.add(bgLabel);

            //set empty space panels             
            pTopage = new JPanel();
            pTopage.setOpaque(false);
            pTopage.setPreferredSize(new Dimension(width, 40));
            
            //set top pane + empty top space
            pTop = new JPanel(new BorderLayout());
            pTop.setOpaque(false);
            pTop.add(pTopage, BorderLayout.NORTH); 
            
            //set button
            URL noUrl = restartPage.class.getResource("/assets/img/btnNoRe.png");
            if (noUrl == null) {
                throw new FileNotFoundException("Button image not found: /assets/img/btnNoRe.png");
            }
            ImageIcon noIcon = new ImageIcon(noUrl);
            Image noScaled = noIcon.getImage().getScaledInstance(320, 120, Image.SCALE_SMOOTH);
            ImageIcon noRe = new ImageIcon(noScaled); 
            btnNo = new JLabel(noRe);
            btnNo.setPreferredSize(new Dimension(320, 120));
            btnNo.setBounds(650,350,380,120);

            // Load YES button image
            URL yesUrl = restartPage.class.getResource("/assets/img/btnYesRe.png");
            if (yesUrl == null) {
                throw new FileNotFoundException("Button image not found: /assets/img/btnYesRe.png");
            }
            ImageIcon yesIcon = new ImageIcon(yesUrl);
            Image yesScaled = yesIcon.getImage().getScaledInstance(380, 120, Image.SCALE_SMOOTH);
            ImageIcon yesRe = new ImageIcon(yesScaled); 
            btnYes = new JLabel(yesRe); btnYes.setLayout(null);
            btnYes.setPreferredSize(new Dimension(380, 120));
            btnYes.setBounds(220,350,380,120);
            
            title = new JLabel("คุณได้กลิ่นอายของไม้เก่าและสมุนไพรอวลอยู่ในอากาศ เปลวเทียนไหวระริกจากสายลมแผ่วเบา");
            title.setFont(customFont.deriveFont(23f));
            title.setForeground(Color.BLACK);
            title.setBounds(100,120,width,200);
            quest = new JLabel("วันนี้เป็นวันแรกของคุณที่นี่... ใช่ไหม?");
            quest.setFont(customFont.deriveFont(28f));
            quest.setForeground(Color.BLACK);
            quest.setBounds(380,190,width,200);

            // Create panel for buttons
            pMid = new JPanel();
            pMid.setLayout(null);
            pMid.add(title);
            pMid.add(quest);
            pMid.add(btnYes);
            pMid.add(btnNo);
            pMid.setPreferredSize(new Dimension(width, 200));
            pMid.setOpaque(false);

            //set main pane
            pMain = new JPanel(new BorderLayout());
            pMain.setBounds(0, 0, width, height);
            pMain.setOpaque(false);
            pMain.add(pTop, BorderLayout.NORTH); 
            pMain.add(pMid); 

            //set layered pane
            pFrame = new JLayeredPane();
            pFrame.setBounds(0, 0, width, height);
            pFrame.add(pBG, JLayeredPane.DEFAULT_LAYER);  
            pFrame.add(pMain, JLayeredPane.PALETTE_LAYER);  

            //set JFrame
            fr.setContentPane(pFrame);
            fr.setVisible(true);
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font or image!");
            e.printStackTrace();
        }

    }
  
    public static void main(String[] args) {
        new restartPage();
    }
}

