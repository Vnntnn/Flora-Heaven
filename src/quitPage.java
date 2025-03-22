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
import java.net.URL;

public class quitPage {
    private JFrame fr;
    private JPanel pName, pTitle, pFootage, pTopage, pButton, pTop, pMain, pBG;
    private JLayeredPane pLayer, pFrame;
    private JLabel title, bgLabel;
    private JButton btnBack;
    private ImageIcon background;

    public quitPage() {
        int width = 1280;
        int height = 720;

        try {
            // โหลดฟอนต์
            InputStream fontStream = creditPage.class.getResourceAsStream("/Pixelpoint.ttf");
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found: /Pixelpoint.ttf");
            }
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            System.out.println("Font loaded successfully!");

            // สร้าง JFrame
            fr = new JFrame("Credit Page");
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr.setSize(width, height);
            fr.setResizable(false);

            // โหลดภาพพื้นหลัง
            URL bgUrl = creditPage.class.getResource("/bg.png");
            if (bgUrl == null) {
                throw new FileNotFoundException("Background image not found: /bg.png");
            }
            Image originalImage = new ImageIcon(bgUrl).getImage();
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            background = new ImageIcon(scaledImage);

            // ตั้งค่า bgLabel ให้เป็นพื้นหลัง
            bgLabel = new JLabel(background);
            bgLabel.setBounds(0, 0, width, height);

            // ตั้งค่า pBG (Panel พื้นหลัง)
            pBG = new JPanel(null);
            pBG.setBounds(0, 0, width, height);
            pBG.add(bgLabel);

            // ตั้งค่า pTitle
            pTitle = new JPanel();
            pTitle.setLayout(new BorderLayout());
            pTitle.setOpaque(true);
            pTitle.setBackground(new Color(0, 0, 0, 100)); // กึ่งโปร่งแสง
            pTitle.setBorder(BorderFactory.createLineBorder(Color.RED, 3)); // เส้นขอบเช็คตำแหน่ง

            title = new JLabel("Credit", SwingConstants.CENTER);
            title.setFont(customFont.deriveFont(100f));
            title.setForeground(Color.WHITE);
            pTitle.add(title, BorderLayout.CENTER);

            pTitle.setBounds(0, 30, width, 100); // ปรับตำแหน่งให้เห็นชัด

            // ตั้งค่า pButton
            pButton = new JPanel();
            pButton.setOpaque(false);
            pButton.setLayout(new FlowLayout(FlowLayout.LEFT));
            btnBack = new JButton("Back");
            pButton.add(btnBack);
            pButton.setBounds(50, 10, 100, 30);

            // ตั้งค่า pName (แสดงรายชื่อนักศึกษา)
            pName = new JPanel();
            pName.setLayout(new GridLayout(10, 1));
            pName.setOpaque(false); // ทำให้ pName โปร่งใส
            JLabel n1 = new JLabel("67070018 จรรยภัทร หิรัญรัตน์", SwingConstants.CENTER);
            n1.setFont(customFont.deriveFont(18f));
            n1.setForeground(Color.WHITE);
            JLabel n2 = new JLabel("67070023 จิรายุ มาระโภชน์", SwingConstants.CENTER);
            n2.setFont(customFont.deriveFont(18f));
            n2.setForeground(Color.WHITE);
            JLabel n3 = new JLabel("67070026 ชนกพรรณ สีมาพล", SwingConstants.CENTER);
            n3.setFont(customFont.deriveFont(18f));
            n3.setForeground(Color.WHITE);
            JLabel n4 = new JLabel("67070042 ฐานพัฒน์ ทองมีรุ่งเรือง", SwingConstants.CENTER);
            n4.setFont(customFont.deriveFont(18f));
            n4.setForeground(Color.WHITE);
            JLabel n5 = new JLabel("67070056 ทิพย์วารี เถาโคตสี", SwingConstants.CENTER);
            n5.setFont(customFont.deriveFont(18f));
            n5.setForeground(Color.WHITE);
            JLabel n6 = new JLabel("67070065 ธนบดี อังกุลดี", SwingConstants.CENTER);
            n6.setFont(customFont.deriveFont(18f));
            n6.setForeground(Color.WHITE);
            JLabel n7 = new JLabel("67070081 ธีธัช สุขวิมลไพศาล", SwingConstants.CENTER);
            n7.setFont(customFont.deriveFont(18f));
            n7.setForeground(Color.WHITE);
            JLabel n8 = new JLabel("67070087 นรีรัศมิ์ จิตตฤกษ์", SwingConstants.CENTER);
            n8.setFont(customFont.deriveFont(18f));
            n8.setForeground(Color.WHITE);
            JLabel n9 = new JLabel("67070146 ยัสมิน่า ฟาริส ยาซีน นาเซอร์", SwingConstants.CENTER);
            n9.setFont(customFont.deriveFont(18f));
            n9.setForeground(Color.WHITE);
            JLabel n10 = new JLabel("67070277 วรภา พุ่มฉัตร", SwingConstants.CENTER);
            n10.setFont(customFont.deriveFont(18f));
            n10.setForeground(Color.WHITE);
            pName.add(n1); pName.add(n2); pName.add(n3); pName.add(n4); pName.add(n5);
            pName.add(n6); pName.add(n7); pName.add(n8); pName.add(n9); pName.add(n10);

            // ตั้งค่า pLayer
            pLayer = new JLayeredPane();
            pLayer.setLayout(null);
            pLayer.setBounds(0, 0, width, 120);
            pLayer.add(pTitle, JLayeredPane.PALETTE_LAYER); // pTitle อยู่ PALETTE_LAYER
            pLayer.add(pButton, JLayeredPane.POPUP_LAYER); // pButton อยู่ POPUP_LAYER

            // ตั้งค่า pMain
            pMain = new JPanel(new BorderLayout());
            pMain.setBounds(0, 0, width, height);
            pMain.setOpaque(false);
            pMain.add(pLayer, BorderLayout.NORTH); // เพิ่ม pLayer ด้านบน
            pMain.add(pName, BorderLayout.CENTER); // เพิ่ม pName ตรงกลาง

            // ใช้ JLayeredPane สำหรับการจัดเลเยอร์
            pFrame = new JLayeredPane();
            pFrame.setBounds(0, 0, width, height);
            pFrame.add(pBG, JLayeredPane.DEFAULT_LAYER);      // พื้นหลัง
            pFrame.add(pMain, JLayeredPane.PALETTE_LAYER);    // คอนเทนต์

            // ตั้งค่า JFrame
            fr.setContentPane(pFrame);
            fr.setVisible(true);

        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font or image!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new quitPage();
    }
}
