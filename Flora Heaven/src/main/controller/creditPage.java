package main.controller;/*
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

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;

public class creditPage {
    private JFrame fr;
    private JPanel pName, pTitle, pFootage, pTopage, pButton, pTop, pMain, pBG;
    private JLayeredPane pLayer, pFrame;
    private JLabel n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, title, bgLabel;
    private JButton btnBack;
    private ImageIcon background;
    private LobbyController controller;

    public creditPage() {
        int width = 1290;
        int height = 755;
        try {
            // โหลดฟอนต์
            InputStream fontStream = creditPage.class.getResourceAsStream("/Font/Pixelpoint.ttf");
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found in resources: /Font/Pixelpoint.ttf");
            }
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            fr = new JFrame("Flora Heaven");
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr.setSize(new Dimension(width, height));
            fr.setResizable(false);

            URL bgUrl = creditPage.class.getResource("/Credits/background.png");
            if (bgUrl == null) {
                throw new FileNotFoundException("Background image not found: /img/bg1.png");
            }
            Image originalImage = new ImageIcon(bgUrl).getImage();
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            background = new ImageIcon(scaledImage);

            bgLabel = new JLabel(background);
            bgLabel.setBounds(0, 0, width, height);

            pBG = new JPanel(null);
            pBG.setBounds(0, 0, width, height);
            pBG.add(bgLabel);

            pTitle = new JPanel();
            pTitle.setLayout(new BorderLayout());
            pTitle.setOpaque(false);

            title = new JLabel("Credit", SwingConstants.CENTER);
            title.setFont(customFont.deriveFont(100f));
            title.setForeground(Color.YELLOW);
            pTitle.add(title, BorderLayout.CENTER);


            pButton = new JPanel();
            pButton.setOpaque(false);
            pButton.setLayout(new FlowLayout());
            btnBack = new JButton("Back");
            btnBack.setFont(customFont.deriveFont(30f));
            btnBack.setForeground(Color.BLACK);
            btnBack.setBackground(Color.YELLOW);
            btnBack.setPreferredSize(new Dimension(150, 50));  // ข้อความอยู่ด้านขวาของรูปภาพ
            btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
            btnBack.setVerticalTextPosition(SwingConstants.CENTER); // ข้อความอยู่กึ่งกลางแนวตั้ง
            btnBack.setContentAreaFilled(false); // ปิดการเติมพื้นหลังเมื่อกด
            btnBack.setBorderPainted(false); // ปิดการวาดขอบปุ่ม
            btnBack.setFocusPainted(false); // ปิดการวาดเส้นขอบเมื่อปุ่มได้รับโฟกัส
            btnBack.setOpaque(true);
            btnBack.setMargin(new Insets(0, 0, 0, 0)); // ลดช่องว่างรอบข้อความ
            btnBack.setBorder(null);
            pButton.add(btnBack);
            pButton.setBounds(50, 10, 100, 100);

            pName = new JPanel();
            pName.setLayout(new GridLayout(10, 1));
            pName.setOpaque(false);
            n1 = new JLabel("67070018 จรรยภัทร หิรัญรัตน์", SwingConstants.CENTER);
            n1.setFont(customFont.deriveFont(18f));
            n1.setForeground(Color.WHITE);
            n2 = new JLabel("67070023 จิรายุ มาระโภชน์", SwingConstants.CENTER);
            n2.setFont(customFont.deriveFont(18f));
            n2.setForeground(Color.WHITE);
            n3 = new JLabel("67070026 ชนกพรรณ สีมาพล", SwingConstants.CENTER);
            n3.setFont(customFont.deriveFont(18f));
            n3.setForeground(Color.WHITE);
            n4 = new JLabel("67070042 ฐานพัฒน์ ทองมีรุ่งเรือง", SwingConstants.CENTER);
            n4.setFont(customFont.deriveFont(18f));
            n4.setForeground(Color.WHITE);
            n5 = new JLabel("67070056 ทิพย์วารี เถาโคตสี", SwingConstants.CENTER);
            n5.setFont(customFont.deriveFont(18f));
            n5.setForeground(Color.WHITE);
            n6 = new JLabel("67070065 ธนบดี อังกุลดี", SwingConstants.CENTER);
            n6.setFont(customFont.deriveFont(18f));
            n6.setForeground(Color.WHITE);
            n7 = new JLabel("67070081 ธีธัช สุขวิมลไพศาล", SwingConstants.CENTER);
            n7.setFont(customFont.deriveFont(18f));
            n7.setForeground(Color.WHITE);
            n8 = new JLabel("67070087 นรีรัศมิ์ จิตตฤกษ์", SwingConstants.CENTER);
            n8.setFont(customFont.deriveFont(18f));
            n8.setForeground(Color.WHITE);
            n9 = new JLabel("67070146 ยัสมิน่า ฟาริส ยาซีน นาเซอร์", SwingConstants.CENTER);
            n9.setFont(customFont.deriveFont(18f));
            n9.setForeground(Color.WHITE);
            n10 = new JLabel("67070277 วรภา พุ่มฉัตร", SwingConstants.CENTER);
            n10.setFont(customFont.deriveFont(18f));
            n10.setForeground(Color.WHITE);
            pName.add(n1); pName.add(n2); pName.add(n3); pName.add(n4); pName.add(n5);
            pName.add(n6); pName.add(n7); pName.add(n8); pName.add(n9); pName.add(n10);

            pLayer = new JLayeredPane();
            pLayer.setPreferredSize(new Dimension(width, 120));
            pLayer.setBounds(0, 0, width, 120);

            pTitle.setBounds(0, 0, width, 120);
            pLayer.add(pTitle, JLayeredPane.DEFAULT_LAYER);

            pButton.setBounds(50, 10, 100, 100);
            pLayer.add(pButton, JLayeredPane.POPUP_LAYER);

            pFootage = new JPanel(); pTopage = new JPanel();
            pFootage.setOpaque(false); pTopage.setOpaque(false);
            pFootage.setPreferredSize(new Dimension(width, 70));
            pTopage.setPreferredSize(new Dimension(width, 25));

            pTop = new JPanel(new BorderLayout());
            pTop.setOpaque(false);
            pTop.add(pLayer, BorderLayout.CENTER);
            pTop.add(pTopage, BorderLayout.NORTH);

            pMain = new JPanel(new BorderLayout());
            pMain.setBounds(0, 0, width, height);
            pMain.setOpaque(false);
            pMain.add(pTop, BorderLayout.NORTH);
            pMain.add(pName, BorderLayout.CENTER);
            pMain.add(pFootage, BorderLayout.SOUTH);

            pFrame = new JLayeredPane();
            pFrame.setBounds(0, 0, width, height);
            pFrame.add(pBG, JLayeredPane.DEFAULT_LAYER);
            pFrame.add(pMain, JLayeredPane.PALETTE_LAYER);

            fr.setContentPane(pFrame);
            fr.setVisible(true);

        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font or image!");
            e.printStackTrace();
        }

        btnBack.addActionListener(e -> {
            btnBack.setBackground(Color.WHITE);

            Timer timer1 = new Timer(500, ev -> {
                btnBack.setBackground(Color.YELLOW);

            });
            timer1.setRepeats(false); // ให้ Timer ทำงานเพียงครั้งเดียว
            timer1.start();

            Timer timer2 = new Timer(600, ev -> {
                controller.getController().getView().setVisible(true);
                fr.dispose(); // เปลี่ยนสีพื้นหลังกลับเป็นสีดำหลังจาก 1 วินาที
            });
            timer2.setRepeats(false); // ให้ Timer ทำงานเพียงครั้งเดียว
            timer2.start();
        });
    }
}