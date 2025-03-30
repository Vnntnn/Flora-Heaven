package main.view.gameplay.Arcanashop;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainQuestGIF extends JPanel{
    public MainQuestGIF(){
        ImageIcon originalIcon = AssetsLoaderArcanashop.mainQuestGIF;
        Image scaledImage = originalIcon.getImage().getScaledInstance(1280, 722, Image.SCALE_DEFAULT);
        ImageIcon resizedGif = new ImageIcon(scaledImage);  
        JLabel giflLabel = new JLabel(resizedGif);
        add(giflLabel);
        setOpaque(false);
    }
}
