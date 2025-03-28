package model.Credits;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CreditsModel {
    private Font customFont;

    public CreditsModel() {
        try {
            InputStream fontStream = CreditsModel.class.getResourceAsStream("/Font/Pixelpoint.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public Font getCustomFont() {
        return customFont;
    }
}
