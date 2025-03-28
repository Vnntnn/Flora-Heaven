package view.Lobby;

import javax.swing.*;

public class startBtnPanel extends JPanel {
    private createButton startBtn;

    public startBtnPanel() {
        startBtn = new createButton("Start", 120, 350);
        startBtn.getButton().setVisible(true);
        add(startBtn);
    }

    public createButton getStartBtn() {
        return startBtn;
    }
}
