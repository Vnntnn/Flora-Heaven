package main.view.Gamewindow;

import main.controller.LobbyController;
import main.view.AssetsLoader.Lobby.*;
import javax.swing.*;
import java.awt.*;

public class LobbyWindow extends JFrame {
    private GameboardPanel gameboardpanel;
    private LobbybackgroundPanel lobbybackgroundpanel;
    private startBtnPanel startbtnpanel;
    private quitBtnPanel quitbtnpanel;
    private creditsBtnPanel creditsbtnpanel;
    private FireflysPanel fireflysPanel;
    private LobbyGifPanel lobbygifpanel;
    private LogoPanel logopanel;
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
        lobbygifpanel = new LobbyGifPanel();
        logopanel = new LogoPanel();
        fireflysPanel = new FireflysPanel(controller);

        lobbybackgroundpanel.setBounds(0, 0, 1290, 755);
        gameboardpanel.setBounds(0, 0, 1290, 755);
        startbtnpanel.setBounds(0, 0, 1290, 755);
        quitbtnpanel.setBounds(0, 0, 1290, 755);
        creditsbtnpanel.setBounds(0, 0, 1290, 755);
        fireflysPanel.setBounds(0, 0, 1290, 755);
        logopanel.setBounds(0, 0, 1290, 755);
        lobbygifpanel.setBounds(0, 0, 1290, 755);

        gameboardpanel.setOpaque(false);
        startbtnpanel.setOpaque(false);
        quitbtnpanel.setOpaque(false);
        creditsbtnpanel.setOpaque(false);
        fireflysPanel.setOpaque(false);
        logopanel.setOpaque(false);
        lobbygifpanel.setOpaque(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1290, 755));

        layeredPane.add(lobbybackgroundpanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(gameboardpanel, Integer.valueOf(1));
        layeredPane.add(fireflysPanel, Integer.valueOf(2));
        layeredPane.add(startbtnpanel, Integer.valueOf(3));
        layeredPane.add(quitbtnpanel, Integer.valueOf(3));
        layeredPane.add(creditsbtnpanel, Integer.valueOf(3));
        layeredPane.add(logopanel, Integer.valueOf(4));
        layeredPane.add(lobbygifpanel, Integer.valueOf(5));

        add(layeredPane);

        Timer timer = new Timer(50, e -> {
            if (controller != null) {
                controller.updateFireflies(getWidth(), getHeight());
                fireflysPanel.repaint();
            }
        });
        timer.setInitialDelay(100);
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

    public static void main(String[] args) {
        new LobbyWindow(new LobbyController());
    }
}