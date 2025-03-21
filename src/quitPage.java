/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chenl
 */
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class quitPage {
    private JFrame fr;
    private JPanel p;
    private JLabel name;

    public quitPage() {
        try {
            InputStream fontStream = creditPage.class.getResourceAsStream("/Pixelpoint.ttf");
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found in resources: /Pixelpoint.ttf");
            }

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            System.out.println("Font loaded successfully!");

            fr = new JFrame("Credit Page");
            p = new JPanel();
            p.setLayout(new BorderLayout());

            name = new JLabel();

            name.setFont(customFont.deriveFont(25f));
            p.add(name, BorderLayout.CENTER);

            fr.add(p);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            int width = 1280;
            int height = 720;
            p.setPreferredSize(new Dimension(width, height));
            fr.setSize(new Dimension(width, height));
            fr.setLocationRelativeTo(null);
            fr.setResizable(false);
            fr.setVisible(true);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Font file not found!");
            e.printStackTrace();
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new quitPage();
    }
}
