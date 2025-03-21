/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chenl
 */
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

public class creditPage {
    private JFrame fr;
    private JPanel p;
    private JLabel name;

    public creditPage() {
        int width = 1280;
        int height = 720;
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

            name = new JLabel("<html><div style='white-space: nowrap;'>"
                    + "67070018 จรรยภัทร หิรัญรัตน์<br>"
                    + "67070023 จิรายุ มาระโภชน์<br>"
                    + "67070026 ชนกพรรณ สีมาพล<br>"
                    + "67070042 ฐานพัฒน์ ทองมีรุ่งเรือง<br>"
                    + "67070056 ทิพย์วารี เถาโคตสี<br>"
                    + "67070065 ธนบดี อังกุลดี<br>"
                    + "67070081 ธีธัช สุขวิมลไพศาล<br>"
                    + "67070087 นรีรัศมิ์ จิตตฤกษ์<br>"
                    + "67070146 ยัสมิน่า ฟาริส ยาซีน นาเซอร์ <br>"
                    + "67070277 วรภา พุ่มฉัตร</div></html>");

            name.setFont(customFont.deriveFont(25f));
            name.setPreferredSize(new Dimension(width, height));
            p.add(name, BorderLayout.CENTER);

            fr.add(p);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
        new creditPage();
    }
}