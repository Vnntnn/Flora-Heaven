import controller.LobbyController;
import view.Gamewindow.LobbyWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LobbyController();
        });
    }
}
