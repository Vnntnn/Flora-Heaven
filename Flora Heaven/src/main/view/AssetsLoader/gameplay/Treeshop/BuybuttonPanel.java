package main.view.AssetsLoader.gameplay.Treeshop;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BuybuttonPanel extends JPanel {
    private int[][] positions;
    private static final BufferedImage buybtn = AssetsLoaderTreeShop.buybtn[0];
    private static final BufferedImage unbuybtn = AssetsLoaderTreeShop.buybtn[1];
    private static final BufferedImage[] btn = new BufferedImage[8];

    public BuybuttonPanel() {

        for (int i = 0; i < btn.length; i++) {
            btn[i] = unbuybtn;
        }

        positions = new int[][]{
                {170, 390}, {400, 390}, {680, 390}, {910, 390},
                {170, 605}, {400, 605}, {680, 605}, {910, 605}
        };
    }

    public void updateButtonState(int index, boolean canBuy) {
        btn[index] = canBuy ? buybtn : unbuybtn;
        repaint(); // วาดใหม่ทันที
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < btn.length; i++) {
            g.drawImage(btn[i], positions[i][0], positions[i][1], 225, 120, this);
        }
    }
}