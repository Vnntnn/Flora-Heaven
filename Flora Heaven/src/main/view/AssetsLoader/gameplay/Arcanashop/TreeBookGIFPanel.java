package main.view.AssetsLoader.gameplay.Arcanashop;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TreeBookGIFPanel extends JPanel{
    public TreeBookGIFPanel(){
        ImageIcon originalIcon = AssetsLoaderArcanashop.plant_CollectionGIF;
        Image scaledImage = originalIcon.getImage().getScaledInstance(1280, 722, Image.SCALE_DEFAULT);
        ImageIcon resizedGif = new ImageIcon(scaledImage);  
        JLabel giflLabel = new JLabel(resizedGif);
        add(giflLabel);
        setOpaque(false);
    }
}
