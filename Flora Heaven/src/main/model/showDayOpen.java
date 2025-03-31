package main.model;

import main.view.Gamewindow.Opening_day;

import javax.swing.*;

public class showDayOpen {
    //showDay(Player player)
    // int dayNumber = player.getDay()
    public showDayOpen(int dayNumber) {
        String imagePath = "/DayOpenAndEnd/Open/Day_" + dayNumber + "_Op.png";
        SwingUtilities.invokeLater(() -> {
            Opening_day frame = new Opening_day(imagePath);
            frame.setVisible(true);
        });
    }
}