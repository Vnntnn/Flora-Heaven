package main.view.Gamewindow;
import main.model.Gameplay.Tree.BaseTrees.Chandra;
import main.model.Gameplay.Tree.BaseTrees.Eclipsara;
import main.model.Gameplay.Tree.BaseTrees.Everguard;
import main.model.Gameplay.Tree.BaseTrees.Heartroot;
import main.model.Gameplay.Tree.BaseTrees.Huolu;
import main.model.Gameplay.Tree.BaseTrees.IllumisSprout;
import main.model.Gameplay.Tree.BaseTrees.Luckybloom;
import main.model.Gameplay.Tree.BaseTrees.Lunacrypta;
import main.model.Gameplay.Tree.BaseTrees.Mindspire;
import main.model.Gameplay.Tree.BaseTrees.SilentisShade;
import main.model.Gameplay.Tree.BaseTrees.Voxspire;
import main.model.Gameplay.Tree.BaseTrees.bloodvalorTree;
import main.model.Player.Player;
import main.model.Player.TreeObtains;
import main.view.gameplay.Arcanashop.*;
import main.view.trees.AssetsLoaderTrees;
import main.view.trees.Bloodvalor_blossomPanel;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class ArcanashopWindow extends JFrame {
    private Player player;
    private TreeHolderShelfPanel treeholdershelfpanel;
    private CounterPanel counterpanel;
    private ShelfBackgroundPanel shelfbackgroundpanel;
    private DeskBackgroundPanel deskbackgroundpanel;
    private QuestsBoardPanel questsboardpanel;
    private MainQuestPanel mainquestpanel;
    private SubQuestPanel subquestpanel;
    private MagicTablePanel magictablepanel;
    private ShopPanel shoppanel;
    private TreesBookPanel treesbookpanel;
    private MailboxPanel mailboxpanel;
    private DaysPanel dayspanel;
    private DaypapercardholderPanel daypapercardholderpanel;
    private JPanel drop1, drop2;
    private JButton mqevent, shop ,book, combine;
    private JButton[] sqevents;
    private JPanel[] treeholders;
    private JLayeredPane layeredPane;
    private SubQuestTextPanel subQuestTextPanel1, subQuestTextPanel2,subQuestTextPanel3;

    public ArcanashopWindow() {
        AssetsLoaderArcanashop.getInstance();
        this.player = new Player();
        player.setDay(5);
        
        player.getObtainTrees().addTree(new Chandra());
        player.getObtainTrees().addTree(new Luckybloom());
        player.getObtainTrees().addTree(new bloodvalorTree());
        player.getObtainTrees().addTree(new Everguard());
        player.getObtainTrees().addTree(new Mindspire());
        player.getObtainTrees().addTree(new Eclipsara());
        player.getObtainTrees().addTree(new Heartroot());
        player.getObtainTrees().addTree(new Huolu());
        player.getObtainTrees().addTree(new IllumisSprout());
        player.getObtainTrees().addTree(new Lunacrypta());
        player.getObtainTrees().addTree(new SilentisShade());
        player.getObtainTrees().addTree(new Voxspire());
        
        // Windows setup
        setTitle("Flora Heaven");
        setSize(1290, 755);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Initializing obj.
        treeholdershelfpanel = new TreeHolderShelfPanel();
        counterpanel = new CounterPanel();
        shelfbackgroundpanel = new ShelfBackgroundPanel();
        deskbackgroundpanel = new DeskBackgroundPanel();
        questsboardpanel = new QuestsBoardPanel(player);
        mainquestpanel = new MainQuestPanel();
        subquestpanel = new SubQuestPanel();
        magictablepanel = new MagicTablePanel();
        shoppanel = new ShopPanel();
        treesbookpanel = new TreesBookPanel();
        mailboxpanel = new MailboxPanel();
        dayspanel = new DaysPanel(player);
        daypapercardholderpanel = new DaypapercardholderPanel();
        subQuestTextPanel1 = new SubQuestTextPanel();
        subQuestTextPanel2 = new SubQuestTextPanel();
        subQuestTextPanel3 = new SubQuestTextPanel();
        combine = new JButton();
        mqevent = new JButton();
        sqevents = new JButton[3];
        for (int i = 0; i < 3; i++) {
            sqevents[i] = new JButton();
        }
        treeholders = new JPanel[12];
        for (int i = 0; i < 12; i++) {
            if (i < player.getObtainTrees().getObtainedTree().size()){
                treeholders[i] = (JPanel) player.getObtainTrees().getObtainedTree().get(i).getImage();
            }
            else{
                treeholders[i] = new JPanel();
            }
            treeholders[i].setOpaque(false);
        }
        shop = new JButton();
        book = new JButton();
        drop1 = new JPanel();       //Area combine tree1
        drop1.setLayout(null);
        drop1.setBounds(507, 470, 138, 146);
        drop1.setOpaque(false);
        drop2 = new JPanel();       //Area combine tree2
        drop2.setLayout(null);
        drop2.setOpaque(false);
        drop2.setBounds(783, 470, 138, 146);

        // Initializing LayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        // setup components sizes
        treeholdershelfpanel.setBounds(0, 0, 1280,720);
        counterpanel.setBounds(0, 0, 1280, 720);
        shelfbackgroundpanel.setBounds(0, 0, 1280, 720);
        deskbackgroundpanel.setBounds(0, 0, 1280, 720);
        questsboardpanel.setBounds(0, 0, 1280, 720);
        mainquestpanel.setBounds(0, 0, 1280, 720);
        subquestpanel.setBounds(0, 0, 1280, 720);
        magictablepanel.setBounds(0, 0, 1280, 720);
        shoppanel.setBounds(0, 0, 1280, 720);
        treesbookpanel.setBounds(0, 0, 1280, 720);
        mailboxpanel.setBounds(0, 0, 1280, 720);
        dayspanel.setBounds(0, 0, 1280, 720);
        daypapercardholderpanel.setBounds(0, 0, 1280, 720);
        mqevent.setBounds(540, 64, 212, 245);
        mqevent.setContentAreaFilled(false);
        mqevent.setBorderPainted(false);
        combine.setBounds(617,435,200,200);
        combine.setContentAreaFilled(false);
        combine.setBorderPainted(false);
        subQuestTextPanel1.setBounds(790,185,125,110);
        subQuestTextPanel2.setBounds(930,185,125,110);
        subQuestTextPanel3.setBounds(1076,185,125,110);

        sqevents[0].setBounds(790,155,125,140);
        sqevents[0].setContentAreaFilled(false);
        sqevents[0].setBorderPainted(false);
        sqevents[1].setBounds(930,155,125,140);
        sqevents[1].setContentAreaFilled(false);
        sqevents[1].setBorderPainted(false);
        sqevents[2].setBounds(1076,155,125,140);
        sqevents[2].setContentAreaFilled(false);
        sqevents[2].setBorderPainted(false);

        treeholders[0].setBounds(23,6,85,85);
        treeholders[0].setBackground(new Color(0,0,0,150));
        treeholders[1].setBounds(132,6,85,85);
        treeholders[1].setBackground(new Color(0,0,0,150));
        treeholders[2].setBounds(240,6,85,85);
        treeholders[2].setBackground(new Color(0,0,0,150));
        treeholders[3].setBounds(345,6,85,85);
        treeholders[3].setBackground(new Color(0,0,0,150));
        treeholders[4].setBounds(20,118,85,85);
        treeholders[4].setBackground(new Color(0,0,0,150));
        treeholders[5].setBounds(132,118,85,85);
        treeholders[5].setBackground(new Color(0,0,0,150));
        treeholders[6].setBounds(240,118,85,85);
        treeholders[6].setBackground(new Color(0,0,0,150));
        treeholders[7].setBounds(342,118,85,85);
        treeholders[7].setBackground(new Color(0,0,0,150));
        treeholders[8].setBounds(18,236,85,85);
        treeholders[8].setBackground(new Color(0,0,0,150));
        treeholders[9].setBounds(130,236,85,85);
        treeholders[9].setBackground(new Color(0,0,0,150));
        treeholders[10].setBounds(235,236,85,85);
        treeholders[10].setBackground(new Color(0,0,0,150));
        treeholders[11].setBounds(340,236,85,85);
        treeholders[11].setBackground(new Color(0,0,0,150));

        shop.setBounds(970,360,129,348);
        shop.setContentAreaFilled(false);
        shop.setBorderPainted(false);
        book.setBounds(1120,360,145,210);
        book.setContentAreaFilled(false);
        book.setBorderPainted(false);

        // Make components background not opacity
        treeholdershelfpanel.setOpaque(false);
        counterpanel.setOpaque(false);
        shelfbackgroundpanel.setOpaque(false);
        deskbackgroundpanel.setOpaque(false);
        questsboardpanel.setOpaque(false);
        mainquestpanel.setOpaque(false);
        subquestpanel.setOpaque(false);
        magictablepanel.setOpaque(false);
        shoppanel.setOpaque(false);
        treesbookpanel.setOpaque(false);
        mailboxpanel.setOpaque(false);
        dayspanel.setOpaque(false);
        daypapercardholderpanel.setOpaque(false);
        subQuestTextPanel1.setOpaque(false);
        subQuestTextPanel2.setOpaque(false);
        subQuestTextPanel3.setOpaque(false);

        // Adding panels to layeredPane
        layeredPane.add(drop1, Integer.valueOf(30));
        layeredPane.add(drop2, Integer.valueOf(24));
        layeredPane.add(shelfbackgroundpanel, Integer.valueOf(1));
        layeredPane.add(treeholdershelfpanel, Integer.valueOf(2));
        layeredPane.add(counterpanel, Integer.valueOf(3));
        layeredPane.add(daypapercardholderpanel, Integer.valueOf(4));
        layeredPane.add(mailboxpanel, Integer.valueOf(5));
        layeredPane.add(deskbackgroundpanel, Integer.valueOf(6));
        layeredPane.add(dayspanel, Integer.valueOf(7));
        layeredPane.add(questsboardpanel, Integer.valueOf(9));
        layeredPane.add(mainquestpanel, Integer.valueOf(10));
        layeredPane.add(subquestpanel, Integer.valueOf(11));
        layeredPane.add(magictablepanel, Integer.valueOf(12));
        layeredPane.add(shoppanel, Integer.valueOf(13));
        layeredPane.add(treesbookpanel, Integer.valueOf(14));
        layeredPane.add(mqevent, Integer.valueOf(16));
        layeredPane.add(combine,Integer.valueOf(17));
        layeredPane.add(subQuestTextPanel1,Integer.valueOf(18));
        layeredPane.add(subQuestTextPanel2,Integer.valueOf(19));
        layeredPane.add(subQuestTextPanel3,Integer.valueOf(20));
        layeredPane.setOpaque(false);

        for (int i = 0; i < 3; i++) {
            int layer_index = 16;
            layeredPane.add(sqevents[i], Integer.valueOf(layer_index));
            layer_index++;
        }

        layeredPane.add(shop, Integer.valueOf(19));
        layeredPane.add(book, Integer.valueOf(20));

        for (int i = 0; i < 12; i++) {
            int layer_index = 21;
            layeredPane.add(treeholders[i], Integer.valueOf(layer_index));
            layer_index++;
        }

        add(layeredPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public JPanel[] getPanel(){
        return treeholders;
    }

    public Player getPlayer(){
        return player;
    }

    public JPanel getDrop1(){
        return drop1;
    }

    public JPanel getDrop2(){
        return drop2;
    }

    public JButton getMainQuest(){
        return mqevent;
    }

    public JButton[] getSubQuest(){
        return sqevents;
    }

    public JButton getBook(){
        return book;
    }

    public JButton getShop(){
        return shop;
    }

    public JButton getCombine(){
        return combine;
    }

    public JLayeredPane getJLayeredPane(){
        return layeredPane;
    }

    public SubQuestTextPanel getsuSubQuestTextPanel1(){
        return subQuestTextPanel1;
    } 
    public SubQuestTextPanel getsuSubQuestTextPanel2(){
        return subQuestTextPanel2;
    } 
    public SubQuestTextPanel getsuSubQuestTextPanel3(){
        return subQuestTextPanel3;
    } 
}