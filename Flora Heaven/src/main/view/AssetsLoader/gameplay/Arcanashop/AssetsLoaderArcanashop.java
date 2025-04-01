package main.view.AssetsLoader.gameplay.Arcanashop;

// ***
// Author: Vnntnn
// ***

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderArcanashop {
    protected static BufferedImage[] treeholder;
    protected static BufferedImage counter;
    protected static BufferedImage shelfbackground;
    protected static BufferedImage treeholdershelf;
    protected static BufferedImage deskbackground;
    protected static BufferedImage questboard;
    protected static BufferedImage mainquest;
    protected static BufferedImage subquest;
    protected static BufferedImage magictable;
    protected static BufferedImage shop;
    protected static BufferedImage treesbook;
    protected static BufferedImage mailsbox;
    protected static BufferedImage[] Dayscard;
    protected static BufferedImage Dayholder;
    protected static ImageIcon mainQuestGIF,subQuest1GIF,subQuest2GIF,subQuest3GIF,shopGIF,plant_CollectionGIF, clockGIF;
    private static AssetsLoaderArcanashop instance = new AssetsLoaderArcanashop();

    private AssetsLoaderArcanashop() {
        try {
            treeholdershelf = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/shelf.png"));
            counter = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/counter.png"));
            shelfbackground = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/shelfbackground.png"));
            deskbackground = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/maingameplay_bg.png"));
            questboard = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/quest_board.png"));
            mainquest = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/main_quest.png"));
            subquest = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/side_quest.png"));
            magictable = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/plant_combine.png"));
            shop = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/shop.png"));
            treesbook = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/plant_collection.png"));
            mailsbox = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/mails_box.png"));
            Dayholder = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/Daypapercard_holder.png"));
            mainQuestGIF = new ImageIcon(AssetsLoaderArcanashop.class.getResource("/assets/Gameplay/GIF/main_quest.GIF"));
            subQuest1GIF = new ImageIcon(AssetsLoaderArcanashop.class.getResource("/assets/Gameplay/GIF/sidequest_blue.GIF"));
            subQuest2GIF = new ImageIcon(AssetsLoaderArcanashop.class.getResource("/assets/Gameplay/GIF/sidequest_green.GIF"));
            subQuest3GIF = new ImageIcon(AssetsLoaderArcanashop.class.getResource("/assets/Gameplay/GIF/sidequest_yellow.GIF"));
            shopGIF = new ImageIcon(AssetsLoaderArcanashop.class.getResource("/assets/Gameplay/GIF/shop.GIF"));
            plant_CollectionGIF = new ImageIcon(AssetsLoaderArcanashop.class.getResource("/assets/Gameplay/GIF/plant_collection.GIF"));
            clockGIF = new ImageIcon(AssetsLoaderArcanashop.class.getResource("/assets/Gameplay/GIF/Clock.GIF"));

            Dayscard = new BufferedImage[5];
            for (int i = 0; i < 5; i++) {
                Dayscard[i] = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/Days/Day" + (i + 1) + ".png"));
            }
            treeholder = new BufferedImage[12];
            for (int i = 0; i < 12; i++) {
                treeholder[i] = ImageIO.read(AssetsLoaderArcanashop.class.getResourceAsStream("/assets/Gameplay/Arcanashop/TreeHolders/" + (i + 1) + ".png"));
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    public static AssetsLoaderArcanashop getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        new AssetsLoaderArcanashop();
    }
}
