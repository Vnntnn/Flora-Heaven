package main.view.Gamewindow;

import main.controller.ShopController;
import main.model.Player.Player;
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
    private ShopController controller;

    public Shopwindow(ShopController controller) {
        this.controller = controller;

        setTitle("Flora Heaven");
        setSize(1290, 755);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        shopbackground = new Shopbackground();
        shoplogo = new Shoplogo();
        candlepanel = new candlePanel();
        fbookpanel = new fbookPanel();
        buybutton = new BuybuttonPanel();

        buypanel = new JPanel[8];
        buy = new JButton[8];

        for (int i = 0; i < 8; i++) {
            buypanel[i] = new JPanel(new GridLayout(1, 1));
            buypanel[i].setBackground(new Color(0,0,0,0));

            buy[i] = new JButton();
            buy[i].setBorderPainted(false);
            buy[i].setContentAreaFilled(false);
            buy[i].setFocusPainted(false);
            controller.setupBuyButton(buy[i], i);
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

        shopbackground.setOpaque(false);
        shoplogo.setOpaque(false);
        buybutton.setOpaque(false);

        layeredPane.add(shopbackground, Integer.valueOf(1));
        layeredPane.add(shoplogo, Integer.valueOf(2));
        layeredPane.add(candlepanel, Integer.valueOf(3));
        layeredPane.add(fbookpanel, Integer.valueOf(4));
        layeredPane.add(buybutton, Integer.valueOf(5));

        for (JPanel panel : buypanel) {
            layeredPane.add(panel, Integer.valueOf(6));
        }

        add(layeredPane, BorderLayout.CENTER);

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
    }

    public static void main(String[] args) {
        Player player = new Player();
        ShopController controller = new ShopController(player);
        new Shopwindow(controller);
    }
}