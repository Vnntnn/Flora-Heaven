package main.controller;

import main.controller.lobby.LobbyController;

import javax.swing.*;

public class FloraHeaven {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LobbyController();
        });
    }
}