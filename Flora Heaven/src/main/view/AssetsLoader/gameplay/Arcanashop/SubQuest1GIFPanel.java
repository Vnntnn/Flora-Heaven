package main.view.gameplay.Arcanashop;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubQuest1GIFPanel extends JPanel{
    public SubQuest1GIFPanel(){
        ImageIcon originalIcon = AssetsLoaderArcanashop.subQuest1GIF;
        Image scaledImage = originalIcon.getImage().getScaledInstance(1280, 722, Image.SCALE_DEFAULT);
        ImageIcon resizedGif = new ImageIcon(scaledImage);  
        JLabel giflLabel = new JLabel(resizedGif);
        add(giflLabel);
        setOpaque(false);
    }
}
