package main.view.AssetsLoader.books;

/**
 * @author Vnntnn
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderBook {
    protected static BufferedImage bookbackground;
    protected static BufferedImage[] Trees;
    protected static BufferedImage[] combinedTrees;
    protected static ImageIcon navleft;
    protected static ImageIcon navright;
    protected static ImageIcon[] swaping;
    private static AssetsLoaderBook instance = new AssetsLoaderBook();

    private AssetsLoaderBook() {
        try {
            bookbackground = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/background.png"));

            Trees = new BufferedImage[12];
            Trees[0] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/luckybloomtxt.png"));
            Trees[1] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/everguardtxt.png"));
            Trees[2] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/bloodvalorblossomtxt.png"));
            Trees[3] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/mindspiretxt.png"));
            Trees[4] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/heartroottxt.png"));
            Trees[5] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/silentisshadetxt.png"));
            Trees[6] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/chandratxt.png"));
            Trees[7] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/illumissprouttxt.png"));
            Trees[8] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/voxspiretxt.png"));
            Trees[9] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/eclipsaratxt.png"));
            Trees[10] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/huolutxt.png"));
            Trees[11] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/Trees/lunacryptatxt.png"));

            combinedTrees = new BufferedImage[6];
            for (int i = 0; i < combinedTrees.length; i++) {
                combinedTrees[i] = ImageIO.read(AssetsLoaderBook.class.getResourceAsStream("/assets/Book/combine/book_page" + (4 + i) + ".png"));
            }

            navleft = new ImageIcon(AssetsLoaderBook.class.getResource("/Book/Animation/ArrowsPage/prev_arrow.GIF"));
            navright = new ImageIcon(AssetsLoaderBook.class.getResource("/Book/Animation/ArrowsPage/next_arrow.GIF"));

            swaping = new ImageIcon[2];
            swaping[0] = new ImageIcon(AssetsLoaderBook.class.getResource("/Book/Animation/Swaping/Next_page.GIF"));
            swaping[1] = new ImageIcon(AssetsLoaderBook.class.getResource("/Book/Animation/Swaping/prev_page.GIF"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssetsLoaderBook getInstance() {
        return instance;
    }
}