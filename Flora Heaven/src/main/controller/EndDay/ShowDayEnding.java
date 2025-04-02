package main.controller.EndDay;

import main.model.Player.Player;
import main.view.Gamewindow.OpenAndEndDay.Day_Ending;
import javax.swing.*;
import java.net.URL;

public class ShowDayEnding {
    private static final String BASE_PATH = "/assets/DayOpenAndEnd/End/Day_";

    public ShowDayEnding(int dayNumber, Player player) {
        int validDay = Math.max(1, Math.min(5, dayNumber)); 
        String imagePath = BASE_PATH + validDay + "_End.png";

        URL imageUrl = getClass().getResource(imagePath);
        System.out.println("Loading ending image from: " + imagePath);
        System.out.println("Actual path: " + (imageUrl != null ? imageUrl.getPath() : "NOT FOUND"));

        SwingUtilities.invokeLater(() -> {
            try {
                if (imageUrl == null) {
                    throw new RuntimeException("Ending image not found for day " + validDay);
                }
                Day_Ending frame = new Day_Ending(imagePath, player);
                frame.setVisible(true);
            } catch (Exception e) {
                handleError(validDay, e);
            }
        });
    }

    private void handleError(int dayNumber, Exception e) {
        System.err.println("Error loading day " + dayNumber + " ending:");
        e.printStackTrace();
        
        JOptionPane.showMessageDialog(null,
            "Failed to load ending for Day " + dayNumber + "\n" + e.getMessage(),
            "Loading Error",
            JOptionPane.ERROR_MESSAGE);
    }
}
