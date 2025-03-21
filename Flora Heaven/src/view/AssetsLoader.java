package view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AssetsLoader {
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
    private static AssetsLoader instance = new AssetsLoader();

    private AssetsLoader() {
        try {
            treeholdershelf = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/shelf.png"));
            treeholder = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/treeholder.png"));
            counter = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/counter.png"));
            shelfbackground = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/shelfbackground.png"));
            deskbackground = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/maingameplay_bg.png"));
            questboard = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/quest_board.png"));
            mainquest = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/main_quest.png"));
            subquest = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/side_quest.png"));
            magictable = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/plant_combine.png"));
            shop = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/shop.png"));
            treesbook = ImageIO.read(AssetsLoader.class.getResourceAsStream("/assets/plant_collection.png"));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    public static AssetsLoader getInstance() {
        return instance;
    }
}
