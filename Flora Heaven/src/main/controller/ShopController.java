package main.controller;

import main.model.Gameplay.Tree.TreesCollections.BaseCollectionTrees;
import main.model.Gameplay.Tree.Tree;
import main.model.Player.Player;
import main.view.AssetsLoader.gameplay.Treeshop.BuybuttonPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShopController {
    private boolean[][] canBuy;
    private int currentDay;
    private Player player;
    private List<Tree> treeList;  // เก็บต้นไม้จาก Collection
    private BuybuttonPanel buybuttonPanel;

    public ShopController(Player player) {
        this.player = player;
        this.treeList = new BaseCollectionTrees().getBaseTrees();  // ดึงต้นไม้ทั้งหมด
        currentDay = player.getDay();

        canBuy = new boolean[][] {
                {true, true, false, false,
                false, false, false, false},  // Day 1

                {false, false, false, true,
                false, false, false, false},  // Day 2

                {false, false, false, false,
                true, false, false, false},  // Day 3

                {false, false, false, false,
                false, true, true, false}, // Day 4

                {false, false, false, false,
                false, false, false, true}   // Day 5
        };
    }

    public void setupBuyButton(JButton button, int index) {
        Tree tree = treeList.get(index);
        updateButtonState(button, index);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canBuy[currentDay - 1][index] && player.getCoins() >= tree.getPrice()) {
                    // หักเงินและซื้อ
                    player.setCoins((int)(player.getCoins() - tree.getPrice()));
                    canBuy[currentDay - 1][index] = false;

                    // ซื้อต้นที่ 2 ปลดล็อกต้นที่ 3
                    if (index == 1) {
                        unlockTreeNextDay(2); // ปลดล็อกต้นที่ 3 ในวันถัดไป
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
}