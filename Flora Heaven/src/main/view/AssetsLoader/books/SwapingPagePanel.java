package main.view.AssetsLoader.books;

import java.awt.*;
import javax.swing.*;

public class SwapingPagePanel extends JPanel {
    private int activeAnimationIndex = -1;
    private JLabel[] animationLabels;

    public SwapingPagePanel() {
        setOpaque(false);
        setLayout(null);
        setVisible(false);
        setDoubleBuffered(true);

        animationLabels = new JLabel[AssetsLoaderBook.swaping.length];
        for (int i = 0; i < AssetsLoaderBook.swaping.length; i++) {
            ImageIcon originalIcon = AssetsLoaderBook.swaping[i];
            Image scaledImage = originalIcon.getImage().getScaledInstance(1290, 755, Image.SCALE_DEFAULT);
            animationLabels[i] = new JLabel(new ImageIcon(scaledImage));
            animationLabels[i].setBounds(0, 0, 1290, 755);
            animationLabels[i].setVisible(false);
            add(animationLabels[i]);
        }
    }

    public void setActiveAnimation(int index) {
        this.activeAnimationIndex = index;
        for (int i = 0; i < animationLabels.length; i++) {
            animationLabels[i].setVisible(i == index);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (activeAnimationIndex >= 0) {
            // วาดเฉพาะ animation ที่ active
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver);
            animationLabels[activeAnimationIndex].paint(g2d);
            g2d.dispose();
        }
    }
}