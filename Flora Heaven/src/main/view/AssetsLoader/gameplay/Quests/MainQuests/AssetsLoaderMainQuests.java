package main.view.AssetsLoader.gameplay.Quests.MainQuests;

// ***
// Author: Vnntnn
// ***

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderMainQuests {
    protected static BufferedImage Questbackground;
    protected static BufferedImage Flowers;
    protected static BufferedImage[] Quests;
    protected static BufferedImage[] Questsnumber;
    private static AssetsLoaderMainQuests instance = new AssetsLoaderMainQuests();

    private AssetsLoaderMainQuests() {
        try {
            Questbackground = ImageIO.read(AssetsLoaderMainQuests.class.getResourceAsStream("/assets/Gameplay/Quests/Main quest/Common/background.png"));
            Flowers = ImageIO.read(AssetsLoaderMainQuests.class.getResourceAsStream("/assets/Gameplay/Quests/Main quest/Common/Flowers.png"));
            Quests = new BufferedImage[5];
            Questsnumber = new BufferedImage[5];
            for (int i = 0; i < 5; i++) {
                Quests[i] = ImageIO.read(AssetsLoaderMainQuests.class.getResourceAsStream("/assets/Gameplay/Quests/Main quest/QuestsDescription/QD" + (i + 1) + ".png"));
                Questsnumber[i] = ImageIO.read(AssetsLoaderMainQuests.class.getResourceAsStream("/assets/Gameplay/Quests/Main quest/QuestsNumber/QN" + (i + 1) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssetsLoaderMainQuests getInstance() {
        return instance;
    }
}
