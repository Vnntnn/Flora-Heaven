package main.controller;

import main.model.Gameplay.Tree.TreesCollections.BaseCollectionTrees;
import main.model.Gameplay.Tree.Tree;
import main.model.Player.Player;
import main.view.AssetsLoader.gameplay.Treeshop.BuybuttonPanel;
import main.view.Gamewindow.ArcanashopWindow;
import main.view.Gamewindow.Shopwindow;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ShopController implements WindowFocusListener , WindowListener {
    private boolean[][] canBuy;
    private int currentDay;
    private Player player;
    private List<Tree> treeList;
    private BuybuttonPanel buybuttonPanel;
    private Shopwindow view;
    private ArcanashopWindow arcanashopWindow;

    public ShopController(Player player, ArcanashopWindow arcanashopWindow) {
        this.player = player;
        this.treeList = new BaseCollectionTrees().getBaseTrees();
        this.arcanashopWindow = arcanashopWindow;

        // Initialize with empty list if null
        if (this.treeList == null) {
            this.treeList = new ArrayList<>();
            System.err.println("Warning: BaseCollectionTrees.getBaseTrees() returned null");
        }
        System.out.println(player.getObtainTrees().getObtainedTree().size()+ " = size");

        currentDay = player.getDay();

        canBuy = new boolean[][] {
                {true, true, false, false, false, false, false, false},  // Day 1
                {false, true, true, false, false, false, false, false},  // Day 2
                {false, true, false, false, true, false, false, false},  // Day 3
                {false, true, false, true, false, true, true, false},   // Day 4
                {false, true, false, true, false, false, false, true}    // Day 5
        };

        // Disable ปุ่มสำหรับต้นไม้ที่ซื้อไปแล้ว
        for (Tree ownedTree : player.getObtainTrees().getObtainedTree()) {
            int index = treeList.indexOf(ownedTree);
            if (index != -1) {
                canBuy[currentDay - 1][index] = false;
            }
        }

        // สร้าง view หลังจาก initialize ข้อมูลทั้งหมดแล้ว
        this.view = new Shopwindow(this);
        view.addWindowFocusListener(this);
    }

    public void setupBuyButton(JButton button, int index) {
        if (index < 0 || index >= treeList.size()) {
            button.setEnabled(false);
            return;
        }

        Tree tree = treeList.get(index);
        updateButtonState(button, index);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canBuy[currentDay - 1][index] && player.getCoins() >= tree.getPrice()) {
                    player.setCoins((int)(player.getCoins() - tree.getPrice()));
                    player.getObtainTrees().addTree(tree);
                    System.out.println(player.getObtainTrees().getObtainedTree().size());
                    arcanashopWindow.loadAllTreeHolders();
                    arcanashopWindow.getLayeredPane().revalidate();
                    arcanashopWindow.getLayeredPane().repaint();
                    System.out.println("In");
                    canBuy[currentDay - 1][index] = false;

                    if (index == 1) {
                        unlockTreeNextDay(3);
                    }

                    updateButtonState(button, index);
                    if (buybuttonPanel != null) {
                        buybuttonPanel.updateButtonState(index, false); // เปลี่ยนเป็น false เมื่อซื้อแล้ว
                    }
                }
            }
        });
    }

    public void updateButtonState(JButton button, int index) {
        boolean canBuyState = canBuy[currentDay - 1][index] &&
                player.getCoins() >= treeList.get(index).getPrice();
        button.setEnabled(canBuyState);
        if (buybuttonPanel != null) {
            buybuttonPanel.updateButtonState(index, canBuyState);
        }
    }

    public boolean canBuy(int index) {
        if (currentDay >= 1 && currentDay <= 5 && index >= 0 && index < 8) {
            return canBuy[currentDay - 1][index];
        }
        return false;
    }

    public void setBuybuttonPanel(BuybuttonPanel panel) { // เพิ่มเมธอด setter
        this.buybuttonPanel = panel;
    }

    private void unlockTreeNextDay(int treeIndex) {
        int nextDay = currentDay; // วันปัจจุบัน (เริ่มจาก 1)
        if (nextDay < 5) { // ตรวจสอบว่ายังไม่เกิน Day 5
            canBuy[nextDay][treeIndex] = true; // วันที่ถัดไป (index = currentDay)
        }
    }

    public static void main(String[] args) {

//        new ShopController(new Player());
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        view.dispose();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        arcanashopWindow.getLayeredPane().revalidate();
        arcanashopWindow.getLayeredPane().repaint();
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public List<Tree> getTreeList() {
        return treeList;
    }

    public Player getPlayer(){
        return player;
    }

}