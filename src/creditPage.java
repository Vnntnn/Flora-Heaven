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
    private JPanel pName, pTitle, pFootage;
    private JLabel n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, title;
    private JButton btnBack;

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
            pTitle = new JPanel(); pName = new JPanel(); pFootage = new JPanel();
            btnBack = new JButton("back");
            
            pFootage.setPreferredSize(new Dimension(width, 50));
            title = new JLabel("Credit", SwingConstants.CENTER);
            title.setFont(customFont.deriveFont(80f));
            n1 = new JLabel("67070018 จรรยภัทร หิรัญรัตน์", SwingConstants.CENTER);
            n1.setFont(customFont.deriveFont(18f));
            n2 = new JLabel("67070023 จิรายุ มาระโภชน์", SwingConstants.CENTER);
            n2.setFont(customFont.deriveFont(18f));
            n3 = new JLabel("67070026 ชนกพรรณ สีมาพล", SwingConstants.CENTER);
            n3.setFont(customFont.deriveFont(18f));
            n4 = new JLabel("67070042 ฐานพัฒน์ ทองมีรุ่งเรือง", SwingConstants.CENTER);
            n4.setFont(customFont.deriveFont(18f));
            n5 = new JLabel("67070056 ทิพย์วารี เถาโคตสี", SwingConstants.CENTER);
            n5.setFont(customFont.deriveFont(18f));
            n6 = new JLabel("67070065 ธนบดี อังกุลดี", SwingConstants.CENTER);
            n6.setFont(customFont.deriveFont(18f));
            n7 = new JLabel("67070081 ธีธัช สุขวิมลไพศาล", SwingConstants.CENTER);
            n7.setFont(customFont.deriveFont(18f));
            n8 = new JLabel("67070087 นรีรัศมิ์ จิตตฤกษ์", SwingConstants.CENTER);
            n8.setFont(customFont.deriveFont(18f));
            n9 = new JLabel("67070146 ยัสมิน่า ฟาริส ยาซีน นาเซอร์", SwingConstants.CENTER);
            n9.setFont(customFont.deriveFont(18f));
            n10 = new JLabel("67070277 วรภา พุ่มฉัตร", SwingConstants.CENTER);
            n10.setFont(customFont.deriveFont(18f));
            
            pTitle.add(title);
            pName.setLayout(new GridLayout(10, 1));
            pName.add(n1); pName.add(n2); pName.add(n3); pName.add(n4); pName.add(n5);
            pName.add(n6); pName.add(n7); pName.add(n8); pName.add(n9); pName.add(n10);
            
            fr.setLayout(new BorderLayout());
            fr.add(pTitle, BorderLayout.NORTH); fr.add(pName); fr.add(pFootage, BorderLayout.SOUTH);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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