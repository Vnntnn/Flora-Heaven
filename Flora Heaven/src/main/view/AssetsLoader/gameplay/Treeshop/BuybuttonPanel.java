package main.view.AssetsLoader.gameplay.Treeshop;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Buybutton extends JPanel {
    private BufferedImage[] buybtn;
    private int[][] positions;
    private int[][] sizes;

    public Buybutton() {
        buybtn = new BufferedImage[8];

        // โหลดภาพทั้งหมด (ใช้ภาพเดียวกันชั่วคราว)
        for (int i = 0; i < buybtn.length; i++) {
            buybtn[i] = AssetsLoaderTreeShop.buybtn[0];
        }

        // กำหนดตำแหน่ง (x, y) ของแต่ละรูป
        positions = new int[][]{
                {202, 427}, {430, 427}, {706, 427}, {934, 427},
                {202, 636}, {430, 636}, {706, 636}, {934, 636}
        };

        // กำหนดขนาด (width, height) ของแต่ละรูป
        sizes = new int[][]{
                {161, 43}, {161, 43}, {161, 43}, {161, 43},
                {161, 43}, {161, 43}, {161, 43}, {161, 43}
        };

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // วาด shoplogo เป็นพื้นหลัง
        g.drawImage(AssetsLoaderTreeShop.shoplogo, 0, 0, getWidth(), getHeight(), this);

        // วาดรูปทั้งหมดตามตำแหน่งและขนาดที่กำหนด
        for (int i = 0; i < buybtn.length; i++) {
            g.drawImage(buybtn[i], positions[i][0], positions[i][1], sizes[i][0], sizes[i][1], this);
        }
    }
}
