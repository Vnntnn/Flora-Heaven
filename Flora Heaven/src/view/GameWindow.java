package view;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        // Windows setup
        setTitle("Flora Heaven");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Initializing obj.
        TreeHolderShelfPanel treeholdershelfpanel = new TreeHolderShelfPanel();
        TreeHolderPanel treeholderpanel = new TreeHolderPanel();
        CounterPanel counterpanel = new CounterPanel();
        ShelfBackgroundPanel shelfbackgroundpanel = new ShelfBackgroundPanel();
        DeskBackgroundPanel deskbackgroundpanel = new DeskBackgroundPanel();
        QuestsBoardPanel questsboardpanel = new QuestsBoardPanel();
        MainQuestPanel mainquestpanel = new MainQuestPanel();
        SubQuestPanel subquestpanel = new SubQuestPanel();
        MagicTablePanel magictablepanel = new MagicTablePanel();
        ShopPanel shoppanel = new ShopPanel();
        TreesBookPanel treesbookpanel = new TreesBookPanel();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1280, 720));

        treeholdershelfpanel.setBounds(0, 0, 1280, 100);

        // Adding panels to layeredPane
        layeredPane.add(treeholdershelfpanel, Integer.valueOf(1));
        layeredPane.add(treeholderpanel, Integer.valueOf(2));
        layeredPane.add(counterpanel, Integer.valueOf(3));
        layeredPane.add(shelfbackgroundpanel, Integer.valueOf(4));
        layeredPane.add(deskbackgroundpanel, Integer.valueOf(5));
        layeredPane.add(questsboardpanel, Integer.valueOf(6));
        layeredPane.add(mainquestpanel, Integer.valueOf(7));
        layeredPane.add(subquestpanel, Integer.valueOf(8));
        layeredPane.add(magictablepanel, Integer.valueOf(9));
        layeredPane.add(shoppanel, Integer.valueOf(10));
        layeredPane.add(treesbookpanel, Integer.valueOf(11));

        // Adding layeredPane to the frame
        add(layeredPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
