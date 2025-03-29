package view.Gamewindow;
import model.Gameplay.Tree.BaseTrees.SilentisShade;
import model.Player.Player;
import view.gameplay.Arcanashop.*;
import view.trees.AssetsLoaderTrees;
import view.trees.Bloodvalor_blossomPanel;
import view.trees.SilenttisshadePanel;

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
    private JPanel mqevent, shop, book;
    private JPanel[] sqevents;
    private JPanel[] treeholders;

    public ArcanashopWindow() {
        AssetsLoaderArcanashop.getInstance();
        this.player = new Player();

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
        mqevent = new JPanel();
        sqevents = new JPanel[3];
        for (int i = 0; i < 3; i++) {
            sqevents[i] = new JPanel();
        }
        treeholders = new JPanel[12];
        for (int i = 0; i < 12; i++) {
            treeholders[i] = new SilenttisshadePanel();
            treeholders[i].setOpaque(false);
        }
        shop = new JPanel();
        book = new JPanel();

        // Initializing LayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
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
        mqevent.setBackground(Color.BLACK);

        sqevents[0].setBounds(790,155,125,140);
        sqevents[0].setBackground(Color.BLACK);
        sqevents[1].setBounds(930,155,125,140);
        sqevents[1].setBackground(Color.BLACK);
        sqevents[2].setBounds(1076,155,125,140);
        sqevents[2].setBackground(Color.BLACK);

        treeholders[0].setBounds(23,5,85,85);
        treeholders[0].setBackground(new Color(0,0,0,150));
        treeholders[1].setBounds(132,5,85,85);
        treeholders[1].setBackground(new Color(0,0,0,150));
        treeholders[2].setBounds(240,5,85,85);
        treeholders[2].setBackground(new Color(0,0,0,150));
        treeholders[3].setBounds(345,5,85,85);
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
        shop.setBackground(Color.BLACK);
        book.setBounds(1120,360,145,210);
        book.setBackground(Color.BLACK);

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

        // Adding panels to layeredPane
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
        layeredPane.add(mqevent, Integer.valueOf(15));

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

    public static void main(String[] args) {
        new ArcanashopWindow();
    }
}