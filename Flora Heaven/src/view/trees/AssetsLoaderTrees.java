package view;

// ***
// Author: Vnntnn
// ***

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderTrees {
    public static BufferedImage bloodvalorblossom;
    public static BufferedImage chandra;
    public static BufferedImage eclipsara;
    public static BufferedImage everguard;
    public static BufferedImage heartroot;
    public static BufferedImage huolu;
    public static BufferedImage illumissprout;
    public static BufferedImage luckybloom;
    public static BufferedImage lunacrypta;
    public static BufferedImage mindspire;
    public static BufferedImage silentisshade;
    public static BufferedImage voxspire;
    private static AssetsLoaderTrees instance = new AssetsLoaderTrees();

    private AssetsLoaderTrees() {
        try {
            bloodvalorblossom = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Bloodvalor_blossom.png"));
            chandra = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Chandra.png"));
            eclipsara = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Eclipsara.png"));
            everguard = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Everguard.png"));
            heartroot = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Heartroot.png"));
            huolu = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Huolu.png"));
            illumissprout = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Illumis Sprout.png"));
            luckybloom = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Lucky_bloom.png"));
            lunacrypta = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Lunacrypta.png"));
            mindspire = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Mindspire.png"));
            silentisshade = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/Trees/Tree Base/Silentis Shade.png"));
            voxspire = ImageIO.read(AssetsLoaderTrees.class.getResourceAsStream("/assets/Trees/Tree Base/Voxspire.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
