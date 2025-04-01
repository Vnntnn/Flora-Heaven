package main.controller.gameplay;

/**
 * @author Vnntnn
 */

import main.controller.common.FailController;
import main.controller.EndDay.ShowDayEnding;
import main.model.Gameplay.BasicCombineTree;
import main.model.Gameplay.SubQuestGenerator;
import main.model.Gameplay.Tree.Tree;
import main.model.Gameplay.Tree.CombineTrees.CrimsonWard;
import main.model.Gameplay.Tree.CombineTrees.Cryptara;
import main.model.Gameplay.Tree.CombineTrees.HeartEclipse;
import main.model.Gameplay.Tree.CombineTrees.LuminousFinder;
import main.model.Gameplay.Tree.CombineTrees.SilentGuardian;
import main.model.Player.Player;
import main.view.Gamewindow.Gameplay.ArcanashopWindow;
import main.view.Gamewindow.Gameplay.MainQuestWindow;
import main.view.AssetsLoader.gameplay.Arcanashop.*;
import main.view.AssetsLoader.gameplay.Arcanashop.SubQuest3GIFPanel.MainQuestGIF;
import main.model.Threads.Timer;
import main.model.Player.EndingDay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.*;

public class ArcanashopController implements MouseMotionListener,MouseListener,ActionListener {
    // Panel initializing
    private ArcanashopWindow arcanashopWindow;
    private MainQuestPanel mainQuestPanel;
    private ShowDayEnding showdayending;
    private ShopGIFPanel shopGIFPanel;
    private TreeBookGIFPanel treeBookGIFPanel;
    private MainQuestGIF mainQuestGIF;
    private SubQuest1GIFPanel subQuest1GIFPanel;
    private SubQuest2GIFPanel subQuest2GIFPanel;
    private SubQuest3GIFPanel subQuest3GIFPanel;

    private HashMap<Component,Point> position; // เก็บ position Tree
    private HashMap<Component, Tree> treeMap;
    private Tree sqTree1,sqTree2,sqTree3;
    private Tree treeResult, treeResultMain;
    private Player player;
    private SubQuestGenerator subQuestGenerator1,subQuestGenerator2,subQuestGenerator3;
    private int mouseX,mouseY;
    private BasicCombineTree combiner;
    private JPanel treeResultimg;
    private Timer timer;
    private JPanel[] treeJPanels;

    public ArcanashopController(Player player) {
        this.player = player;
        player.setDay(player.getDay());
        // Timer start
        this.timer = new Timer(900); // 15 นาที
        startTimer();

        this.arcanashopWindow = new ArcanashopWindow(this);
        this.mainQuestPanel = new MainQuestPanel();
        treeBookGIFPanel = new TreeBookGIFPanel();
        mainQuestGIF = new MainQuestGIF();
        shopGIFPanel = new ShopGIFPanel();
        subQuest1GIFPanel = new SubQuest1GIFPanel();
        subQuest2GIFPanel = new SubQuest2GIFPanel();
        subQuest3GIFPanel = new SubQuest3GIFPanel();

        position = new HashMap<>();
        combiner = new BasicCombineTree();
        treeMap = new HashMap<>();
        switch (player.getDay()) {
            case 1:
                treeResultMain = new CrimsonWard();
                break;
            case 2:
                treeResultMain = new SilentGuardian();
                break;
            case 3:
                treeResultMain = new LuminousFinder();
                break;
            case 4:
                treeResultMain = new HeartEclipse();
                break;
            case 5:
                treeResultMain = new Cryptara();
                break;
        }

        subQuestGenerator1 = new SubQuestGenerator();
        sqTree1 = subQuestGenerator1.generatorSubQuestTree(player.getDay());
        arcanashopWindow.getsuSubQuestTextPanel1().getHintJLabel2().setText(subQuestGenerator1.gethintString1()+" กับ");
        arcanashopWindow.getsuSubQuestTextPanel1().getHintJLabel3().setText(subQuestGenerator1.gethintString2());

        subQuestGenerator2= new SubQuestGenerator();
        sqTree2 = subQuestGenerator2.generatorSubQuestTree(player.getDay());
        arcanashopWindow.getsuSubQuestTextPanel2().getHintJLabel2().setText(subQuestGenerator2.gethintString1()+" กับ");
        arcanashopWindow.getsuSubQuestTextPanel2().getHintJLabel3().setText(subQuestGenerator2.gethintString2());

        subQuestGenerator3 = new SubQuestGenerator();
        sqTree3 = subQuestGenerator3.generatorSubQuestTree(player.getDay());
        arcanashopWindow.getsuSubQuestTextPanel3().getHintJLabel2().setText(subQuestGenerator3.gethintString1()+" กับ");
        arcanashopWindow.getsuSubQuestTextPanel3().getHintJLabel3().setText(subQuestGenerator3.gethintString2());

        // Fetch tree from player
        for (int i = 0;i<player.getObtainTrees().getObtainedTree().size(); i++){
            treeMap.put(player.getObtainTrees().getObtainedTree().get(i).getImage(),player.getObtainTrees().getObtainedTree().get(i));
        }

        treeJPanels = arcanashopWindow.getPanel();
        for (int i = 0; i < 12; i++){
            treeJPanels[i].addMouseListener(this);
            treeJPanels[i].addMouseMotionListener(this);
            position.put(treeJPanels[i], treeJPanels[i].getLocation());
        }
        for (int i = 0; i<3;i++){
            arcanashopWindow.getSubQuest()[i].addMouseListener(this);
            arcanashopWindow.getSubQuest()[i].addActionListener(this);
        }
        arcanashopWindow.getMainQuest().addMouseListener(this);
        arcanashopWindow.getShop().addMouseListener(this);
        arcanashopWindow.getBook().addMouseListener(this);
        arcanashopWindow.getMainQuest().addActionListener(this);
        arcanashopWindow.getShop().addActionListener(this);
        arcanashopWindow.getBook().addActionListener(this);
        arcanashopWindow.getCombine().addActionListener(this);
        arcanashopWindow.getsuSubQuestTextPanel1().addMouseListener(this);
        arcanashopWindow.getsuSubQuestTextPanel2().addMouseListener(this);
        arcanashopWindow.getsuSubQuestTextPanel3().addMouseListener(this);
    }

    public void updatetreeMap(){
        treeMap.clear();
        for (int i = 0;i<player.getObtainTrees().getObtainedTree().size(); i++){
            treeMap.put(player.getObtainTrees().getObtainedTree().get(i).getImage(),player.getObtainTrees().getObtainedTree().get(i));
        }
    }

    public Player getPlayer() {
        return player;
    }

    // Start timer thread
    private void startTimer() {
        Thread timerThread = new Thread(() -> {
            while (!timer.isTimeUp()) {
                int minutes = timer.getSec() / 60;
                int seconds = timer.getSec() % 60;

                SwingUtilities.invokeLater(() -> {
                    arcanashopWindow.getTimeLabel().setText(String.format("%02d:%02d", minutes, seconds));
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            SwingUtilities.invokeLater(() -> {
                arcanashopWindow.dispose();
                new FailController(player);
            });
        });
        timer.start();
        timerThread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == arcanashopWindow.getMainQuest()) {
            new MainQuestWindow(player);
        }
        else if(e.getSource() == arcanashopWindow.getShop()) {
            new ShopController(player,arcanashopWindow);
            arcanashopWindow.loadAllTreeHolders(); // Initializing all trees
        }
        else if (e.getSource()==arcanashopWindow.getBook()){
            new BookController(player);
        }
        else if(e.getSource()==arcanashopWindow.getCombine()){
            if (arcanashopWindow.getDrop1().getComponentCount()==1 && arcanashopWindow.getDrop2().getComponentCount()==1){
                updatetreeMap();
                Component first = arcanashopWindow.getDrop1().getComponent(0);
                Component second = arcanashopWindow.getDrop2().getComponent(0);
                Container c1 = (Container) first;
                Container c2 = (Container) second;
                Component checkkey1 = c1.getComponent(0);
                Component checkkey2 = c2.getComponent(0);
                Tree tree1 = treeMap.get(checkkey1);
                Tree tree2 = treeMap.get(checkkey2);
                if(arcanashopWindow.getLayeredPane().isAncestorOf(treeResultimg)){
                    arcanashopWindow.getLayeredPane().remove(treeResultimg);
                }
                treeResult = combiner.combine(tree1, tree2);
                treeResultimg = (JPanel) treeResult.getImage();
                treeResultimg.setBounds(630,450,140,140);
                treeResultimg.setOpaque(false);
                treeResultimg.addMouseListener(this);
                treeResultimg.addMouseMotionListener(this);
                arcanashopWindow.getDrop1().getComponent(0).setLocation(position.get(arcanashopWindow.getDrop1().getComponent(0)));
                arcanashopWindow.getDrop2().getComponent(0).setLocation(position.get(arcanashopWindow.getDrop2().getComponent(0)));
                arcanashopWindow.getLayeredPane().add(arcanashopWindow.getDrop1().getComponent(0), Integer.valueOf(30));
                arcanashopWindow.getLayeredPane().add(arcanashopWindow.getDrop2().getComponent(0), Integer.valueOf(30));
                arcanashopWindow.getLayeredPane().add(treeResultimg,Integer.valueOf(12));
                arcanashopWindow.getLayeredPane().revalidate();
                arcanashopWindow.getLayeredPane().repaint();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (e.getComponent().getBounds().intersects(arcanashopWindow.getMainQuest().getBounds())){
            mainQuestGIF.setBounds(0, -5, 1280, 755);
            arcanashopWindow.getLayeredPane().add(mainQuestGIF,Integer.valueOf(15));
        }
        else if (e.getComponent().getBounds().intersects(arcanashopWindow.getSubQuest()[0].getBounds())){
            subQuest1GIFPanel.setBounds(0, -5, 1280, 755);
            arcanashopWindow.getLayeredPane().add(subQuest1GIFPanel,Integer.valueOf(16));
            arcanashopWindow.getLayeredPane().remove(arcanashopWindow.getsuSubQuestTextPanel1());
            arcanashopWindow.getLayeredPane().add(arcanashopWindow.getsuSubQuestTextPanel1());
        }
        else if (e.getComponent().getBounds().intersects(arcanashopWindow.getSubQuest()[1].getBounds())){
            subQuest2GIFPanel.setBounds(0, -5, 1280, 755);
            arcanashopWindow.getLayeredPane().add(subQuest2GIFPanel,Integer.valueOf(16));
            arcanashopWindow.getLayeredPane().remove(arcanashopWindow.getsuSubQuestTextPanel2());
            arcanashopWindow.getLayeredPane().add(arcanashopWindow.getsuSubQuestTextPanel2());
        }
        else if (e.getComponent().getBounds().intersects(arcanashopWindow.getSubQuest()[2].getBounds())){
            subQuest3GIFPanel.setBounds(0, -5, 1280, 755);
            arcanashopWindow.getLayeredPane().add(subQuest3GIFPanel,Integer.valueOf(16));
            arcanashopWindow.getLayeredPane().remove(arcanashopWindow.getsuSubQuestTextPanel3());
            arcanashopWindow.getLayeredPane().add(arcanashopWindow.getsuSubQuestTextPanel3());
        }
        else if (e.getComponent().getBounds().intersects(arcanashopWindow.getShop().getBounds())){
            shopGIFPanel.setBounds(0, -5, 1280, 755);
            arcanashopWindow.getLayeredPane().add(shopGIFPanel,Integer.valueOf(16));
        }
        else if (e.getComponent().getBounds().intersects(arcanashopWindow.getBook().getBounds())){
            treeBookGIFPanel.setBounds(0, -5, 1280, 755);
            arcanashopWindow.getLayeredPane().add(treeBookGIFPanel,Integer.valueOf(16));
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getComponent() != treeResultimg){
            e.getComponent().setLocation(e.getXOnScreen()-mouseX-arcanashopWindow.getX(),e.getYOnScreen()-mouseY-arcanashopWindow.getY());
            arcanashopWindow.getLayeredPane().add(e.getComponent(),Integer.valueOf(31));
            arcanashopWindow.getLayeredPane().setLayer(e.getComponent(), Integer.valueOf(31));
        }
        else if (e.getComponent() == treeResultimg){
            e.getComponent().setLocation(e.getXOnScreen()-mouseX-arcanashopWindow.getX(),e.getYOnScreen()-mouseY-arcanashopWindow.getY());
            arcanashopWindow.getLayeredPane().add(e.getComponent(),Integer.valueOf(31));
            arcanashopWindow.getLayeredPane().setLayer(e.getComponent(), Integer.valueOf(31));

        }
        if(e.getComponent().getBounds().intersects(arcanashopWindow.getMainQuest().getBounds())){
            arcanashopWindow.getLayeredPane().repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Component c = e.getComponent();
        boolean found = false;
        for (JPanel panel : arcanashopWindow.getPanel()) {
            if (panel == c) { // หรือใช้ panel.equals(c) ขึ้นอยู่กับความต้องการ
                found = true;
                break;
            }
        }
        if (found) {
            // ทำอะไรสักอย่างเมื่อพบ Component c ใน treeholders
            if(c.getBounds().intersects(arcanashopWindow.getDrop1().getBounds())){
                if (arcanashopWindow.getDrop1().getComponentCount() == 0){ //if Drop1 is Empty
                    c.setLocation(25,25);
                    arcanashopWindow.getDrop1().add(c); //add component to Drop1
                }
                else{ //if Drop1 have component
                    arcanashopWindow.getDrop1().getComponents()[0].setLocation(position.get(arcanashopWindow.getDrop1().getComponents()[0]));       //reset position component in Drop1
                    arcanashopWindow.getLayeredPane().add(arcanashopWindow.getDrop1().getComponents()[0]);
                    arcanashopWindow.getDrop1().removeAll();
                    c.setLocation(25,25);
                    arcanashopWindow.getDrop1().add(c); //add new Component in Drop1
                }
            }

            else if(c.getBounds().intersects(arcanashopWindow.getDrop2().getBounds())){ //if component in Drop2
                if (arcanashopWindow.getDrop2().getComponentCount() == 0){ //if Drop2 is Empty
                    c.setLocation(25,25);
                    arcanashopWindow.getDrop2().add(c);
                }
                else{
                    arcanashopWindow.getDrop2().getComponents()[0].setLocation(position.get(arcanashopWindow.getDrop2().getComponents()[0]));   //reset position component in Drop2
                    arcanashopWindow.getLayeredPane().add(arcanashopWindow.getDrop2().getComponents()[0],Integer.valueOf(30));
                    arcanashopWindow.getDrop2().removeAll();
                    c.setLocation(25,25);
                    arcanashopWindow.getDrop2().add(c); //add component to Drop2
                }
            }

            else{
                c.setLocation(position.get(c)); //reset position
                arcanashopWindow.getLayeredPane().remove(c); //remove
                arcanashopWindow.getLayeredPane().add(c, Integer.valueOf(30)); //add to frame

            }

            // Update and refresh screen
            arcanashopWindow.getDrop1().revalidate();
            arcanashopWindow.getDrop1().repaint();
            arcanashopWindow.getDrop2().revalidate();
            arcanashopWindow.getDrop2().repaint();
            arcanashopWindow.getLayeredPane().revalidate();
            arcanashopWindow.getLayeredPane().repaint();
        }
        else if(c == treeResultimg && c.getBounds().intersects(arcanashopWindow.getsuSubQuestTextPanel1().getBounds())){
            if (treeResult.getName() == sqTree1.getName()){
                player.addCoins(sqTree1.getPrice());
                arcanashopWindow.getLayeredPane().remove(treeResultimg);
                subQuestGenerator1 = new SubQuestGenerator();
                sqTree1 = subQuestGenerator1.generatorSubQuestTree(player.getDay());
                arcanashopWindow.getsuSubQuestTextPanel1().getHintJLabel2().setText(subQuestGenerator1.gethintString1()+" กับ");
                arcanashopWindow.getsuSubQuestTextPanel1().getHintJLabel3().setText(subQuestGenerator1.gethintString2());
            }
            else{
                arcanashopWindow.getLayeredPane().remove(treeResultimg);
            }
        }
        else if(c == treeResultimg && c.getBounds().intersects(arcanashopWindow.getsuSubQuestTextPanel2().getBounds())){
            if (treeResult.getName() == sqTree2.getName()){
                player.addCoins(sqTree2.getPrice());
                arcanashopWindow.getLayeredPane().remove(treeResultimg);
                subQuestGenerator1 = new SubQuestGenerator();
                sqTree2 = subQuestGenerator2.generatorSubQuestTree(player.getDay());
                arcanashopWindow.getsuSubQuestTextPanel2().getHintJLabel2().setText(subQuestGenerator2.gethintString1()+" กับ");
                arcanashopWindow.getsuSubQuestTextPanel2().getHintJLabel3().setText(subQuestGenerator2.gethintString2());
            }
            else{
                arcanashopWindow.getLayeredPane().remove(treeResultimg);
            }
        }
        else if(c == treeResultimg && c.getBounds().intersects(arcanashopWindow.getsuSubQuestTextPanel3().getBounds())){
            if (treeResult.getName() == sqTree3.getName()){
                player.addCoins(sqTree3.getPrice());
                arcanashopWindow.getLayeredPane().remove(treeResultimg);
                subQuestGenerator3 = new SubQuestGenerator();
                sqTree3 = subQuestGenerator3.generatorSubQuestTree(player.getDay());
                arcanashopWindow.getsuSubQuestTextPanel3().getHintJLabel2().setText(subQuestGenerator3.gethintString1()+" กับ");
                arcanashopWindow.getsuSubQuestTextPanel3().getHintJLabel3().setText(subQuestGenerator3.gethintString2());
            }
            else{
                arcanashopWindow.getLayeredPane().remove(treeResultimg);
            }
        }
        else if (c == treeResultimg && c.getBounds().intersects(arcanashopWindow.getMainQuest().getBounds())){
            if (treeResult.getName() == treeResultMain.getName()) {
                switch (player.getDay()) {
                    case 1:
                        arcanashopWindow.dispose();
                        showdayending = new ShowDayEnding(player.getDay(),player);
                        player.addCoins(100);
                        new EndingDay(player).dayEnd();
                        break;
                    case 2:
                        player.addCoins(300);
                        arcanashopWindow.dispose();
                        showdayending = new ShowDayEnding(player.getDay(),player);
                        new EndingDay(player).dayEnd();
                        break;
                    case 3:
                        player.addCoins(500);
                        arcanashopWindow.dispose();
                        showdayending = new ShowDayEnding(player.getDay(),player);
                        new EndingDay(player).dayEnd();
                        break;
                    case 4:
                        player.addCoins(888.0);
                        arcanashopWindow.dispose();
                        showdayending = new ShowDayEnding(player.getDay(),player);
                        new EndingDay(player).dayEnd();
                        break;
                    case 5:
                        arcanashopWindow.dispose();
                        showdayending = new ShowDayEnding(player.getDay(),player);
                        new EndingDay(player).dayEnd();
                        break;
                }
                arcanashopWindow.getLayeredPane().remove(treeResultimg);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent().getBounds().intersects(arcanashopWindow.getMainQuest().getBounds())){
            arcanashopWindow.getLayeredPane().remove(mainQuestGIF);
            arcanashopWindow.getLayeredPane().revalidate();
            arcanashopWindow.getLayeredPane().repaint();
        }
        else if(e.getComponent().getBounds().intersects(arcanashopWindow.getSubQuest()[0].getBounds())){
            arcanashopWindow.getLayeredPane().remove(subQuest1GIFPanel);
            arcanashopWindow.getLayeredPane().revalidate();
            arcanashopWindow.getLayeredPane().repaint();
        }
        else if(e.getComponent().getBounds().intersects(arcanashopWindow.getSubQuest()[1].getBounds())){
            arcanashopWindow.getLayeredPane().remove(subQuest2GIFPanel);
            arcanashopWindow.getLayeredPane().revalidate();
            arcanashopWindow.getLayeredPane().repaint();
        }
        else if(e.getComponent().getBounds().intersects(arcanashopWindow.getSubQuest()[2].getBounds())){
            arcanashopWindow.getLayeredPane().remove(subQuest3GIFPanel);
            arcanashopWindow.getLayeredPane().revalidate();
            arcanashopWindow.getLayeredPane().repaint();
        }
        else if(e.getComponent().getBounds().intersects(arcanashopWindow.getShop().getBounds())){
            arcanashopWindow.getLayeredPane().remove(shopGIFPanel);
            arcanashopWindow.getLayeredPane().revalidate();
            arcanashopWindow.getLayeredPane().repaint();
        }
        else if(e.getComponent().getBounds().intersects(arcanashopWindow.getBook().getBounds())){
            arcanashopWindow.getLayeredPane().remove(treeBookGIFPanel);
            arcanashopWindow.getLayeredPane().revalidate();
            arcanashopWindow.getLayeredPane().repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}