package view.Credits;

/*
@author chenl
*/

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AssetsLoaderCredits {
    protected static BufferedImage creditsbackground;
    private static AssetsLoaderCredits instance = new AssetsLoaderCredits();

    public AssetsLoaderCredits() {
        try {
            creditsbackground = ImageIO.read(AssetsLoaderCredits.class.getResourceAsStream("/Credits/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssetsLoaderCredits getInstance() {
        return instance;
    }
}
