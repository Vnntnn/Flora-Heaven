package main.controller.OpenDay;

import main.model.Player.Player;
import main.view.Gamewindow.OpenAndEndDay.Opening_day;

import javax.swing.*;

public class ShowDayOpen {
    private Player player;

    public ShowDayOpen(int dayNumber, Player player) {
        this.player = player;
        String imagePath = "/DayOpenAndEnd/Open/Day_" + dayNumber + "_Op.png";
        SwingUtilities.invokeLater(() -> {
            Opening_day frame = new Opening_day(imagePath,player);
            frame.setVisible(true);
        });
    }
}