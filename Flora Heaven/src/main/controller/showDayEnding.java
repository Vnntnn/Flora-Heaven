package main.controller;

import main.view.Gamewindow.Day_Ending;

import javax.swing.*;

public class showDayEnding {
    public showDayEnding(int dayNumber) { //showDay(Player player)
        // int dayNumber = player.getDay()
        String imagePath = "/DayOpenAndEnd/End/Day_" + dayNumber + "_End.png";
        SwingUtilities.invokeLater(() -> {
            Day_Ending frame = new Day_Ending(imagePath);
            frame.setVisible(true);
        });
    }
}
