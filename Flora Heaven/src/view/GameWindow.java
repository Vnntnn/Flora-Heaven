package view;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private TreeHolderShelfPanel treeholdershelfpanel;
    private TreeHolderPanel treeholderpanel;
    private CounterPanel counterpanel;
    private ShelfBackgroundPanel shelfbackgroundpanel;
    private DeskBackgroundPanel deskbackgroundpanel;
    private QuestsBoardPanel questsboardpanel;
    private MainQuestPanel mainquestpanel;
    private SubQuestPanel subquestpanel;
    private MagicTablePanel magictablepanel;
    private ShopPanel shoppanel;
    private TreesBookPanel treesbookpanel;

    public GameWindow() {
        AssetsLoader.getInstance();

        // Windows setup
        setTitle("Flora Heaven");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Initializing obj.
        treeholdershelfpanel = new TreeHolderShelfPanel();
        treeholderpanel = new TreeHolderPanel();
        counterpanel = new CounterPanel();
        shelfbackgroundpanel = new ShelfBackgroundPanel();
        deskbackgroundpanel = new DeskBackgroundPanel();
        questsboardpanel = new QuestsBoardPanel();
        mainquestpanel = new MainQuestPanel();
        subquestpanel = new SubQuestPanel();
        magictablepanel = new MagicTablePanel();
        shoppanel = new ShopPanel();
        treesbookpanel = new TreesBookPanel();

        // Initializing LayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1280, 720));

        // setup components sizes
        treeholdershelfpanel.setBounds(0, 0, 1280,600);
        treeholderpanel.setBounds(0, 0, 1280, 620);
        counterpanel.setBounds(0, 0, 1280, 690);
        shelfbackgroundpanel.setBounds(0, 0, 1280, 720);
        deskbackgroundpanel.setBounds(0, 0, 1280, 720);
        questsboardpanel.setBounds(0, 0, 1280, 720);
        mainquestpanel.setBounds(0, 0, 1280, 720);
        subquestpanel.setBounds(0, 0, 1280, 720);
        magictablepanel.setBounds(0, 0, 1280, 720);
        shoppanel.setBounds(0, 0, 1280, 720);
        treesbookpanel.setBounds(0, 0, 1280, 720);

        // Make components background not opacity
        treeholdershelfpanel.setOpaque(false);
        treeholderpanel.setOpaque(false);
        counterpanel.setOpaque(false);
        shelfbackgroundpanel.setOpaque(false);
        deskbackgroundpanel.setOpaque(false);
        questsboardpanel.setOpaque(false);
        mainquestpanel.setOpaque(false);
        subquestpanel.setOpaque(false);
        magictablepanel.setOpaque(false);
        shoppanel.setOpaque(false);
        treesbookpanel.setOpaque(false);

        // Adding panels to layeredPane
        layeredPane.add(treeholdershelfpanel, Integer.valueOf(4));
        layeredPane.add(treeholderpanel, Integer.valueOf(4));
        layeredPane.add(counterpanel, Integer.valueOf(4));
        layeredPane.add(shelfbackgroundpanel, Integer.valueOf(4));
        layeredPane.add(deskbackgroundpanel, Integer.valueOf(5));
        layeredPane.add(questsboardpanel, Integer.valueOf(6));
        layeredPane.add(mainquestpanel, Integer.valueOf(7));
        layeredPane.add(subquestpanel, Integer.valueOf(8));
        layeredPane.add(magictablepanel, Integer.valueOf(9));
        layeredPane.add(shoppanel, Integer.valueOf(10));
        layeredPane.add(treesbookpanel, Integer.valueOf(11));

        add(layeredPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
