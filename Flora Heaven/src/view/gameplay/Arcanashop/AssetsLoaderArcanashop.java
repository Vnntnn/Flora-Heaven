package view.gameplay;

// ***
// Author: Vnntnn
// ***

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderGameplay {
    public static BufferedImage treeholdershelf;
    public static BufferedImage[] treeholder;
    public static BufferedImage counter;
    public static BufferedImage shelfbackground;
    public static BufferedImage deskbackground;
    public static BufferedImage questboard;
    public static BufferedImage mainquest;
    public static BufferedImage subquest;
    public static BufferedImage magictable;
    public static BufferedImage shop;
    public static BufferedImage treesbook;
    public static BufferedImage mailsbox;
    public static BufferedImage[] Dayscard;
    public static BufferedImage Dayholder;
    private static AssetsLoaderGameplay instance = new AssetsLoaderGameplay();

    private AssetsLoaderGameplay() {
        try {
            treeholdershelf = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/shelf.png"));
            counter = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/counter.png"));
            shelfbackground = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/Background/shelfbackground.png"));
            deskbackground = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/Background/maingameplay_bg.png"));
            questboard = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/quest_board.png"));
            mainquest = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/main_quest.png"));
            subquest = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/side_quest.png"));
            magictable = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/plant_combine.png"));
            shop = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/shop.png"));
            treesbook = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/plant_collection.png"));
            mailsbox = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/mails_box.png"));
            Dayholder = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/Daypapercard_holder.png"));
            Dayscard = new BufferedImage[5];
            for (int i = 0; i < 5; i++) {
                Dayscard[i] = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/Days/Day" + (i + 1) + ".png"));
            }
            treeholder = new BufferedImage[12];
            for (int i = 0; i < 12; i++) {
                treeholder[i] = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/TreeHolders/" + (i + 1) + ".png"));
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    public static AssetsLoaderGameplay getInstance() {
        return instance;
    }
}
