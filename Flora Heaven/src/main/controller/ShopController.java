package main.controller;

import main.model.Gameplay.Tree.TreesCollections.BaseCollectionTrees;
import main.model.Gameplay.Tree.Tree;
import main.model.Player.Player;
import main.view.AssetsLoader.gameplay.Treeshop.BuybuttonPanel;
import main.view.Gamewindow.Shopwindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.List;

public class ShopController implements WindowFocusListener {
    private boolean[][] canBuy;
    private int currentDay;
    private Player player;
    private List<Tree> treeList;
    private BuybuttonPanel buybuttonPanel;
    private Shopwindow view;

    public ShopController(Player player) {
        this.player = player;
        this.treeList = new BaseCollectionTrees().getBaseTrees();

        // Initialize with empty list if null
        if (this.treeList == null) {
            this.treeList = new ArrayList<>();
            System.err.println("Warning: BaseCollectionTrees.getBaseTrees() returned null");
        }

        currentDay = player.getDay();

        canBuy = new boolean[][] {
                {true, true, false, false, false, false, false, false},  // Day 1
                {false, false, false, true, false, false, false, false},  // Day 2
                {false, false, false, false, true, false, false, false},  // Day 3
                {false, false, false, false, false, true, true, false},   // Day 4
                {false, false, false, false, false, false, false, true}    // Day 5
        };

        // สร้าง view หลังจาก initialize ข้อมูลทั้งหมดแล้ว
        this.view = new Shopwindow(this);
        view.addWindowFocusListener(this);
    }

    public void setupBuyButton(JButton button, int index) {
        // ตรวจสอบขอบเขตของ index
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
                    canBuy[currentDay - 1][index] = false;

                    if (index == 1) {
                        unlockTreeNextDay(2);
                    }

                    updateButtonState(button, index);
                    if (buybuttonPanel != null) {
                        buybuttonPanel.updateButtonState(index, false);
                    }
                }
            }
        });
    }

    public void updateButtonState(JButton button, int index) {
        if (canBuy[currentDay - 1][index]) {
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
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
        new ShopController(new Player());
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        view.dispose();
    }
}