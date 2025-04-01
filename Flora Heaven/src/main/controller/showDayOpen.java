package main.controller;

import main.model.Player.Player;
import main.view.Gamewindow.Opening_day;

import javax.swing.*;

public class showDayOpen {
    private Player player;
    //showDay(Player player)
    // int dayNumber = player.getDay()
    public showDayOpen(int dayNumber, Player player) {
        this.player = player;
        String imagePath = "/DayOpenAndEnd/Open/Day_" + dayNumber + "_Op.png";
        SwingUtilities.invokeLater(() -> {
            Opening_day frame = new Opening_day(imagePath,player);
            frame.setVisible(true);
        });
    }
}