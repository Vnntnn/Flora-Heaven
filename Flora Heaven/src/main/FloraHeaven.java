package main;

import main.controller.LobbyController;

import javax.swing.*;

public class FloraHeaven {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LobbyController();
        });
    }
}
