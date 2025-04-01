package main.view.AssetsLoader.gameplay.Arcanashop;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubQuest3GIFPanel extends JPanel{
    public SubQuest3GIFPanel(){
        ImageIcon originalIcon = AssetsLoaderArcanashop.subQuest3GIF;
        Image scaledImage = originalIcon.getImage().getScaledInstance(1280, 722, Image.SCALE_DEFAULT);
        ImageIcon resizedGif = new ImageIcon(scaledImage);  
        JLabel giflLabel = new JLabel(resizedGif);
        add(giflLabel);
        setOpaque(false);
    }

    public static class MainQuestGIF extends JPanel{
        public MainQuestGIF(){
            ImageIcon originalIcon = AssetsLoaderArcanashop.mainQuestGIF;
            Image scaledImage = originalIcon.getImage().getScaledInstance(1280, 722, Image.SCALE_DEFAULT);
            ImageIcon resizedGif = new ImageIcon(scaledImage);
            JLabel giflLabel = new JLabel(resizedGif);
            add(giflLabel);
            setOpaque(false);
        }
    }
}
