package main.controller.OpenDay;

import main.model.Player.Player;
import main.view.Gamewindow.OpenAndEndDay.Opening_day;
import javax.swing.*;
import java.net.URL;

public class ShowDayOpen {
    private static final String BASE_PATH = "/assets/DayOpenAndEnd/Open/Day_";

    public ShowDayOpen(int dayNumber, Player player) {
        int validDay = Math.max(1, Math.min(5, dayNumber));
        String imagePath = BASE_PATH + validDay + "_Op.png";

        URL imageUrl = getClass().getResource(imagePath);
        System.out.println("Loading opening image from: " + imagePath);
        System.out.println("Actual path: " + (imageUrl != null ? imageUrl.getPath() : "NOT FOUND"));

        SwingUtilities.invokeLater(() -> {
            try {
                if (imageUrl == null) {
                    throw new RuntimeException("Opening image not found for day " + validDay);
                }
                Opening_day frame = new Opening_day(imagePath, player);
                frame.setVisible(true);
            } catch (Exception e) {
                handleError(validDay, e);
            }
        });
    }

    private void handleError(int dayNumber, Exception e) {
        System.err.println("Error loading day " + dayNumber + " opening:");
        e.printStackTrace();
        
        JOptionPane.showMessageDialog(null,
            "Failed to load opening for Day " + dayNumber + "\n" + e.getMessage(),
            "Loading Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
