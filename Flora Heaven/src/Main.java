import controller.LobbyController;
import view.Gamewindow.LobbyWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LobbyController controller = new LobbyController();
            JFrame frame = new JFrame("Flora Heaven");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            LobbyWindow panel = new LobbyWindow(controller);
            frame.add(panel);
            frame.setSize(1290, 755);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
