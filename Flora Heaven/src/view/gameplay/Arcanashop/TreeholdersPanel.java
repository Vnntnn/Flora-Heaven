package view.gameplay.Arcanashop;

// ***
// Author: Vnntnn
// ***

import model.Gameplay.Tree.TreesCollections.*;
import javax.swing.*;
import java.awt.*;

public class TreeholdersPanel extends JPanel {
    private TreesCollections trees;

    public TreeholdersPanel() {
        this.trees = new TreesCollections();
        setLayout(new GridLayout(3, 4)); // จัดให้เป็นตาราง 3x4
        initTreePanels();
    }

    private void initTreePanels() {
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            JPanel treePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(AssetsLoaderArcanashop.treeholder[finalI], 0, 0, getWidth(), getHeight(), this);
                }
            };
            treePanel.setPreferredSize(new Dimension(getWidth(), getHeight())); // กำหนดขนาดของแต่ละต้นไม้
            treePanel.add(trees.getTrees().get(i).getImage()); // สมมติว่ามี getTreeImage()
            add(treePanel);
        }
    }
}
