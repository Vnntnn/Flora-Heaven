package main.controller;

import main.model.Gameplay.Tree.TreesCollections.BaseCollectionTrees;
import main.model.Gameplay.Tree.Tree;
import main.model.Player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShopController {
    private boolean[][] canBuy;
    private int currentDay;
    private Player player;
    private List<Tree> treeList;  // เก็บต้นไม้จาก Collection

    public ShopController(Player player) {
        this.player = player;
        this.treeList = new BaseCollectionTrees().getBaseTrees();  // ดึงต้นไม้ทั้งหมด
        currentDay = player.getDay();

        canBuy = new boolean[][] {
                {true, true, false, false, false, false, false, false},  // Day 1
                {false, false, false, true, false, false, false, false},  // Day 2
                {false, false, false, false, true, false, false, false},  // Day 3
                {false, false, false, false, false, true, true, false}, // Day 4
                {false, false, false, false, false, false, false, true}   // Day 5
        };
    }

    public void setupBuyButton(JButton button, int index) {
        Tree tree = treeList.get(index);  // ดึงข้อมูลต้นไม้

        updateButtonState(button, index);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canBuy[currentDay - 1][index] && player.getCoins() >= tree.getPrice()) {
                    player.setCoins((int) (player.getCoins() - tree.getPrice())); // หักเงิน
                    System.out.println("ซื้อ " + tree.getName() + " ราคา " + tree.getPrice() + " Coins!");

                    canBuy[currentDay - 1][index] = false;

                    // เงื่อนไข: ถ้าซื้อต้นที่ 2 ต้นที่ 3 จะปลดล็อก
                    if (index == 1) {
                        canBuy[currentDay - 1][2] = true;
                        updateButtonState(button, 2);
                    }

                    updateButtonState(button, index);
                } else {
                    System.out.println("เงินไม่พอ! ต้องการ " + tree.getPrice() + " Coins");
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
}