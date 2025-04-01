package main.view.AssetsLoader.gameplay.Treeshop;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BuybuttonPanel extends JPanel {
    private int[][] positions;
    private BufferedImage[] btnImages; // เก็บภาพปุ่มทั้ง 8 ปุ่ม
    private boolean[] buttonStates; // เก็บสถานะของแต่ละปุ่ม

    public BuybuttonPanel() {
        // กำหนดตำแหน่งปุ่มทั้ง 8 ปุ่ม
        positions = new int[][]{
                {170, 390}, {400, 390}, {680, 390}, {910, 390},
                {170, 605}, {400, 605}, {680, 605}, {910, 605}
        };

        // เริ่มต้นภาพปุ่มและสถานะ
        btnImages = new BufferedImage[8];
        buttonStates = new boolean[8];

        // โหลดภาพเริ่มต้น (ซื้อไม่ได้)
        for (int i = 0; i < btnImages.length; i++) {
            btnImages[i] = AssetsLoaderTreeShop.unbuybtn[i];
            buttonStates[i] = false;
        }
    }

    public void updateButtonState(int index, boolean canBuy) {
        if (index >= 0 && index < btnImages.length) {
            buttonStates[index] = canBuy;
            btnImages[index] = canBuy ? AssetsLoaderTreeShop.unbuybtn[index] : AssetsLoaderTreeShop.buybtn[index];
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < btnImages.length; i++) {
            g.drawImage(btnImages[i], positions[i][0], positions[i][1], 225, 120, this);
        }
    }
}