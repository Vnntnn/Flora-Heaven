package view.Lobby;

import view.Lobby.createButton;

import javax.swing.*;

public class creditsBtnPanel extends JPanel {
    private createButton creditseButton;

    public creditsBtnPanel() {
        setLayout(null);
        setOpaque(false);
        creditseButton = new createButton("Credits", 120, 400);
        creditseButton.getButton().setVisible(true);
        add(creditseButton);
    }

    public createButton getCreditseButton() {
        return creditseButton;
    }
}
