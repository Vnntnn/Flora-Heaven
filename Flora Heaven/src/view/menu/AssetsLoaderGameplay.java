package view.menu;

// ***
// Author: Vnntnn
// ***

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderGameplay {
    public static BufferedImage treeholdershelf;
    public static BufferedImage treeholder;
    public static BufferedImage counter;
    public static BufferedImage shelfbackground;
    public static BufferedImage deskbackground;
    public static BufferedImage questboard;
    public static BufferedImage mainquest;
    public static BufferedImage subquest;
    public static BufferedImage magictable;
    public static BufferedImage shop;
    public static BufferedImage treesbook;
    private static AssetsLoaderGameplay instance = new AssetsLoaderGameplay();

    private AssetsLoaderGameplay() {
        try {
            treeholdershelf = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/shelf.png"));
            treeholder = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/treeholder.png"));
            counter = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/counter.png"));
            shelfbackground = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/shelfbackground.png"));
            deskbackground = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/maingameplay_bg.png"));
            questboard = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/quest_board.png"));
            mainquest = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/main_quest.png"));
            subquest = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/side_quest.png"));
            magictable = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/plant_combine.png"));
            shop = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/shop.png"));
            treesbook = ImageIO.read(AssetsLoaderGameplay.class.getResourceAsStream("/assets/Gameplay/plant_collection.png"));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    public static AssetsLoaderGameplay getInstance() {
        return instance;
    }
}
