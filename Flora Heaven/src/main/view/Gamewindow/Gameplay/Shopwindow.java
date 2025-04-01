package main.view.Gamewindow.Gameplay;

import main.controller.gameplay.ShopController;
import main.model.Gameplay.Tree.TreesCollections.BaseCollectionTrees;
import main.view.AssetsLoader.gameplay.Treeshop.*;

import javax.swing.*;
import java.awt.*;

public class Shopwindow extends JFrame {
    private Shopbackground shopbackground;
    private Shoplogo shoplogo;
    private candlePanel candlepanel;
    private fbookPanel fbookpanel;
    private JPanel[] buypanel;
    private JButton[] buy;
    private BuybuttonPanel buybutton;
    private BaseCollectionTrees basecollectiontrees;
    private ShopController controller;

    public Shopwindow(ShopController controller) {
        AssetsLoaderTreeShop.getInstance();
        this.controller = controller;

        setTitle("Flora Heaven");
        setSize(1290, 755);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        shopbackground = new Shopbackground();
        shoplogo = new Shoplogo();
        candlepanel = new candlePanel();
        fbookpanel = new fbookPanel();
        buybutton = new BuybuttonPanel();
        basecollectiontrees = new BaseCollectionTrees();

        controller.setBuybuttonPanel(buybutton);

        buypanel = new JPanel[8];
        buy = new JButton[8];

        for (int i = 0; i < 8; i++) {
            buypanel[i] = new JPanel(new GridLayout(1, 1));
            buypanel[i].setBackground(new Color(0,0,0,0));

            buy[i] = new JButton();
            buy[i].setBorderPainted(false);
            buy[i].setContentAreaFilled(false);
            buy[i].setFocusPainted(false);

            // Check if tree is already owned
            boolean alreadyOwned = controller.getPlayer().getObtainTrees().getObtainedTree()
                    .contains(controller.getTreeList().get(i));

            if (!alreadyOwned) {
                controller.setupBuyButton(buy[i], i);
            } else {
                buy[i].setEnabled(false);
            }

            buybutton.updateButtonState(i, controller.canBuy(i) && !alreadyOwned);

            buypanel[i].add(buy[i]);
        }

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        shopbackground.setBounds(0, 0, 1290, 755);
        shoplogo.setBounds(0, 0, 1290, 755);
        candlepanel.setBounds(0, 0, 1290, 755);
        fbookpanel.setBounds(0, 0, 1290, 755);
        buybutton.setBounds(0, 0, 1290, 755);

        buypanel[0].setBounds(202, 427, 161, 43);
        buypanel[1].setBounds(430, 427, 161, 43);
        buypanel[2].setBounds(706, 427, 161, 43);
        buypanel[3].setBounds(934, 427, 161, 43);
        buypanel[4].setBounds(202, 636, 161, 43);
        buypanel[5].setBounds(430, 636, 161, 43);
        buypanel[6].setBounds(706, 636, 161, 43);
        buypanel[7].setBounds(934, 636, 161, 43);

        int width = 150; int height = 150;
        int y;
        for (int i = 0; i < 8; i++) {
            if (i < 4) {
                y = 260;
                switch (i) {
                    case 0:
                        basecollectiontrees.getBaseTrees().get(i).getImage().setBounds(208, 290, width, height);
                        break;
                    case 1:
                        basecollectiontrees.getBaseTrees().get(i).getImage().setBounds(430, 265, width, height);
                        break;
                    case 2:
                        basecollectiontrees.getBaseTrees().get(i).getImage().setBounds(712, y, width, height);
                        break;
                    case 3:
                        basecollectiontrees.getBaseTrees().get(i).getImage().setBounds(948, y, width, height);
                        break;
                }
            } else {
                y = 477;
                switch (i) {
                    case 4:
                        basecollectiontrees.getBaseTrees().get(i).getImage().setBounds(202, y, width, height);
                        break;
                    case 5:
                        basecollectiontrees.getBaseTrees().get(i).getImage().setBounds(435, y, width, height);
                        break;
                    case 6:
                        basecollectiontrees.getBaseTrees().get(i).getImage().setBounds(713, y, width, height);
                        break;
                    case 7:
                        basecollectiontrees.getBaseTrees().get(i).getImage().setBounds(945, y, width, height);
                        break;
                }
            }
        }

        shopbackground.setOpaque(false);
        shoplogo.setOpaque(false);
        buybutton.setOpaque(false);

        layeredPane.add(shopbackground, Integer.valueOf(1));
        layeredPane.add(shoplogo, Integer.valueOf(2));
        layeredPane.add(candlepanel, Integer.valueOf(3));
        layeredPane.add(fbookpanel, Integer.valueOf(4));
        layeredPane.add(buybutton, Integer.valueOf(5));

        for (int i = 0; i < 8; i++) {
            layeredPane.add(basecollectiontrees.getBaseTrees().get(i).getImage(), Integer.valueOf(i + 2));
        }

        for (JPanel panel : buypanel) {
            layeredPane.add(panel, Integer.valueOf(6));
        }

        add(layeredPane, BorderLayout.CENTER);

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
    }

    public void updateBuyButtonImage(int index, boolean canBuy) {
        buybutton.updateButtonState(index, canBuy);
    }
}