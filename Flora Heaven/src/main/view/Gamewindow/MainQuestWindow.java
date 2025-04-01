package main.view.Gamewindow;

// ***
// Author: Vnntnn
// ***

import main.model.Player.Player;
import main.view.AssetsLoader.gameplay.Quests.MainQuests.*;
import javax.swing.*;
import java.awt.*;

public class MainQuestWindow extends JFrame {
    private Player player;
    private QuestbackgroundPanel questbackgroundpanel;
    private QuestDescriptionsPanel questdescriptionspanel;
    private QuestNumberPanel questnumberpanel;
    private FlowersPanel flowerspanel;

    public MainQuestWindow(Player player) {
        AssetsLoaderMainQuests.getInstance();
        this.player = player;


        // Windows setup
        setTitle("Main Quest");
        setSize(1290, 755);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Initializing obj.
        questbackgroundpanel = new QuestbackgroundPanel();
        questdescriptionspanel = new QuestDescriptionsPanel(player);
        questnumberpanel = new QuestNumberPanel(player);
        flowerspanel = new FlowersPanel();

        // Initializing LayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        // setup components sizes
        questbackgroundpanel.setBounds(0, 0, 1280,720);
        questdescriptionspanel.setBounds(0, 0, 1280, 720);
        questnumberpanel.setBounds(0, 0, 1280, 720);
        flowerspanel.setBounds(0, 0, 1280, 720);

        // Make components background not opacity
        questbackgroundpanel.setOpaque(false);
        questdescriptionspanel.setOpaque(false);
        questnumberpanel.setOpaque(false);
        flowerspanel.setOpaque(false);

        // Adding panels to layereedPane
        layeredPane.add(questbackgroundpanel, Integer.valueOf(1));
        layeredPane.add(questdescriptionspanel, Integer.valueOf(2));
        layeredPane.add(questnumberpanel, Integer.valueOf(3));
        layeredPane.add(flowerspanel, Integer.valueOf(4));

        add(layeredPane, BorderLayout.CENTER);

        setVisible(true);
    }
}