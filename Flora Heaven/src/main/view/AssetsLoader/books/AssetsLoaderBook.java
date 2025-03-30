package main.view.AssetsLoader.books;

/**
 * @author Vnntnn
 */

import main.view.AssetsLoader.gameplay.Treeshop.AssetsLoaderTreeShop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class AssetsLoaderBook {
    protected static BufferedImage bookbackground;
    protected static BufferedImage[] Trees;
    protected static ImageIcon navleft;
    protected static ImageIcon navright;
    private static AssetsLoaderBook instance = new AssetsLoaderBook();

    private AssetsLoaderBook() {
        try {
            bookbackground = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/background.png"));

            Trees = new BufferedImage[12];
            Trees[0] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/bloodvalorblossomtxt.png"));
            Trees[1] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/chandratxt.png"));
            Trees[2] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/eclipsaratxt.png"));
            Trees[3] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/everguardtxt.png"));
            Trees[4] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/heartroottxt.png"));
            Trees[5] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/huolutxt.png"));
            Trees[6] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/illumissprouttxt.png"));
            Trees[7] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/luckybloomtxt.png"));
            Trees[8] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/lunacryptatxt.png"));
            Trees[9] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/mindspiretxt.png"));
            Trees[10] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/silentisshadetxt.png"));
            Trees[11] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/voxspiretxt.png"));

            navleft = new ImageIcon(AssetsLoaderBook.class.getResource("/assets/Book/ArrowsPage/prev_arrow.GIF"));
            navright = new ImageIcon(AssetsLoaderBook.class.getResource("/assets/Book/ArrowsPage/next_arrow.GIF"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssetsLoaderBook getInstance() {
        return instance;
    }
}