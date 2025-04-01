package main.controller.EndDay;

import main.model.Player.Player;
import main.view.Gamewindow.OpenAndEndDay.Day_Ending;

import javax.swing.*;

public class ShowDayEnding {
    private Player player;

    public ShowDayEnding(int dayNumber, Player player) { //showDay(Player player)
        // int dayNumber = player.getDay()
        String imagePath = "/DayOpenAndEnd/End/Day_" + dayNumber + "_End.png";
        SwingUtilities.invokeLater(() -> {
            Day_Ending frame = new Day_Ending(imagePath,player);
            frame.setVisible(true);
        });
    }
}
