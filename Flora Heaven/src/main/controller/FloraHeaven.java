package main.controller;

import javax.swing.*;

public class FloraHeaven {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LobbyController();
        });
    }
}
