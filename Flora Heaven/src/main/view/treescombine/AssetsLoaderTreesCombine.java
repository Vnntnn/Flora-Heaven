package main.view.treescombine;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.view.trees.AssetsLoaderTrees;

public class AssetsLoaderTreesCombine {
    public static BufferedImage AurelianWhisper;
    public static BufferedImage Harmonspire;
    public static BufferedImage LuminousFinder;
    public static BufferedImage SilentGuardian;
    public static BufferedImage HeartEclipse;
    public static BufferedImage CrimsonWard;
    public static BufferedImage MoonfortuneBloom;
    public static BufferedImage Cryptara;
    public static BufferedImage Valorvine;
    public static BufferedImage Emberveil;
    public static BufferedImage FortunaeVine;
    public static BufferedImage Rootten;
    private static AssetsLoaderTreesCombine instance = new AssetsLoaderTreesCombine();

    private AssetsLoaderTreesCombine(){
        try {
            AurelianWhisper = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Aurelianwhisper.png"));
            Harmonspire = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Harmonspire.png"));
            LuminousFinder = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Luminous.png"));
            SilentGuardian = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Slient Guardian.png"));
            HeartEclipse = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Heart Eclipse.png"));
            CrimsonWard = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Crimson Ward.png"));
            MoonfortuneBloom = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Moonfortune.png"));
            Cryptara = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Cryptara.png"));
            Valorvine = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Valor Vine.png"));
            Emberveil = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Emberveli.png"));
            FortunaeVine = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Fortunae Vine.png"));
            Rootten = ImageIO.read(AssetsLoaderTreesCombine.class.getResourceAsStream("/assets/Gameplay/TreeCombine/Naow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
