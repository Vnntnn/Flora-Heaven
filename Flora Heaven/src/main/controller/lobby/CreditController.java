package main.controller.lobby;

import main.view.Gamewindow.lobby.CreditView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class CreditController {
    private CreditView view;
    private final LobbyController lobbyController;

    public CreditController(LobbyController lobbyController) {
        this.lobbyController = lobbyController;
    }

    public void show() {
        try {
            Font customFont = loadFontWithFallback();
            Image background = loadBackgroundImage("/assets/img/bg1.png");
            
            view = new CreditView(customFont, lobbyController);
            view.setBackgroundImage(background);
            view.setNames(getCreditNames());

            SwingUtilities.invokeLater(() -> {
                view.show();
                view.toFront();
            });
        } catch (IOException e) {
            handleResourceError(e);
        }
    }

    private Font loadFontWithFallback() {
        try {
            InputStream fontStream = getClass().getResourceAsStream("/assets/Font/Pixelpoint.ttf");
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found in resources");
            }
            return Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(12f);
        } catch (Exception e) {
            System.err.println("Using fallback font: " + e.getMessage());
            return new Font("SansSerif", Font.PLAIN, 12);
        }
    }

    private Image loadBackgroundImage(String path) throws IOException {
        URL imageUrl = getClass().getResource(path);
        if (imageUrl == null) {
            throw new FileNotFoundException("Background image not found: " + path);
        }
        return new ImageIcon(imageUrl).getImage();
    }

    private List<String> getCreditNames() {
        return Arrays.asList(
            "67070018 จรรยภัทร หิรัญรัตน์",
            "67070023 จิรายุ มาระโภชน์",
            "67070026 ชนกพรรณ สีมาพล",
            "67070042 ฐานพัฒน์ ทองมีรุ่งเรือง",
            "67070056 ทิพย์วารี เถาโคตสี",
            "67070065 ธนบดี อังกุลดี",
            "67070081 ธีธัช สุขวิมลไพศาล",
            "67070087 นรีรัศมิ์ จิตตฤกษ์",
            "67070146 ยัสมิน่า ฟาริส ยาซีน นาเซอร์",
            "67070277 วรภา พุ่มฉัตร"
        );
    }

    private void handleResourceError(Exception e) {
        System.err.println("Error loading resources: " + e.getMessage());
        JOptionPane.showMessageDialog(null,
            "Failed to load resources: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        

        if (lobbyController != null) {
            lobbyController.getView().setVisible(true);
        }
    }
}
