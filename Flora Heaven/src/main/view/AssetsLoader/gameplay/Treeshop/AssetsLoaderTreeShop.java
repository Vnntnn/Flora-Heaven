package main.view.AssetsLoader.gameplay.Treeshop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderTreeShop {
    protected static BufferedImage shopbackground;
    protected static BufferedImage shoplogo;
    protected static ImageIcon candle;
    protected static ImageIcon fbook;
    protected static BufferedImage[] buybtn;
    protected static BufferedImage[] unavailabletrees;
    private static AssetsLoaderTreeShop instance = new AssetsLoaderTreeShop();

    private AssetsLoaderTreeShop() {
        try {
            shopbackground = ImageIO.read(AssetsLoaderTreeShop.class.getResourceAsStream("/assets/Gameplay/TreeShop/Background/background.png"));
            shoplogo = ImageIO.read(AssetsLoaderTreeShop.class.getResourceAsStream("/assets/Gameplay/TreeShop/Text/logo.png"));

            buybtn = new BufferedImage[2];
            buybtn[0] = ImageIO.read(AssetsLoaderTreeShop.class.getResourceAsStream("/assets/Gameplay/TreeShop/Buttons/Available/btn.png"));
            buybtn[1] = ImageIO.read(AssetsLoaderTreeShop.class.getResourceAsStream("/assets/Gameplay/TreeShop/Buttons/Unavailable/btn.png"));

            unavailabletrees = new BufferedImage[12];
            for (int i = 0; i < unavailabletrees.length; i++) {
                unavailabletrees[i] = ImageIO.read(AssetsLoaderTreeShop.class.getResourceAsStream("/assets/Gameplay/TreeShop/Unavailable trees/IMG_49" + (i + 1) + ".png"));
            }

            candle = new ImageIcon(AssetsLoaderTreeShop.class.getResource("/assets/Gameplay/TreeShop/Animation gifs/1.GIF"));
            fbook = new ImageIcon(AssetsLoaderTreeShop.class.getResource("/assets/Gameplay/TreeShop/Animation gifs/2.GIF"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssetsLoaderTreeShop getInstance() {
        return instance;
    }
}
