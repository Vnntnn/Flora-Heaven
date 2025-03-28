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

        gameboardpanel = new GameboardPanel();
        lobbybackgroundpanel = new LobbybackgroundPanel();
        startbtnpanel = new startBtnPanel();
        quitbtnpanel = new quitBtnPanel();
        creditsbtnpanel = new creditsBtnPanel();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        gameboardpanel.setBounds(0, 0, 1290, 755);
        lobbybackgroundpanel.setBounds(0, 0, 1290, 755);
        startbtnpanel.setBounds(0, 0, 1290, 755);
        quitbtnpanel.setBounds(0, 0, 1290, 755);
        creditsbtnpanel.setBounds(0, 0, 1290, 755);

        gameboardpanel.setOpaque(false);
        lobbybackgroundpanel.setOpaque(false);
        startbtnpanel.setOpaque(false);
        quitbtnpanel.setOpaque(false);
        creditsbtnpanel.setOpaque(false);

        layeredPane.add(gameboardpanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(lobbybackgroundpanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(startbtnpanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(creditsbtnpanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(quitbtnpanel, JLayeredPane.PALETTE_LAYER);

        add(layeredPane, BorderLayout.CENTER);

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
