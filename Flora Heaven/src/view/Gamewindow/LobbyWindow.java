package view.Gamewindow;

import controller.LobbyController;
import view.Lobby.*;

import javax.swing.*;
import java.awt.*;

public class LobbyWindow extends JFrame {
    private GameboardPanel gameboardpanel;
    private LobbybackgroundPanel lobbybackgroundpanel;
    private startBtnPanel startbtnpanel;
    private quitBtnPanel quitbtnpanel;
    private creditsBtnPanel creditsbtnpanel;
    private LobbyController controller;

    public LobbyWindow(LobbyController controller) {
        this.controller = controller;

        setTitle("Flora Heaven");
        setSize(1290, 755);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        lobbybackgroundpanel = new LobbybackgroundPanel();
        gameboardpanel = new GameboardPanel();
        startbtnpanel = new startBtnPanel();
        quitbtnpanel = new quitBtnPanel();
        creditsbtnpanel = new creditsBtnPanel();

        lobbybackgroundpanel.setBounds(0, 0, 1290, 755);
        gameboardpanel.setBounds(0, 0, 1290, 755);
        startbtnpanel.setBounds(0, 0, 1290, 755);
        quitbtnpanel.setBounds(0, 0, 1290, 755);
        creditsbtnpanel.setBounds(0, 0, 1290, 755);

        gameboardpanel.setOpaque(false);
        startbtnpanel.setOpaque(false);
        quitbtnpanel.setOpaque(false);
        creditsbtnpanel.setOpaque(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        layeredPane.add(lobbybackgroundpanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(gameboardpanel, Integer.valueOf(1));
        layeredPane.add(startbtnpanel, Integer.valueOf(2));
        layeredPane.add(quitbtnpanel, Integer.valueOf(2));
        layeredPane.add(creditsbtnpanel, Integer.valueOf(2));

        add(layeredPane);

        Timer timer = new Timer(50, e -> {
            controller.updateFireflies(getWidth(), getHeight());
            repaint();
        });
        timer.start();

        setVisible(true);
    }

    public JButton getStartButton() {
        return startbtnpanel.getStartBtn();
    }

    public JButton getCreditsButton() {
        return creditsbtnpanel.getCreditseButton();
    }

    public JButton getQuitButton() {
        return quitbtnpanel.getQuitBtn();
    }
}
