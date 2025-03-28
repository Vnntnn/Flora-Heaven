package view.Lobby;

import javax.swing.*;

public class quitBtnPanel extends JPanel {
    private createButton quitBtn;

    public quitBtnPanel() {
        quitBtn = new createButton("Quit", 120, 350);
        quitBtn.getButton().setVisible(true);
        add(quitBtn);
    }

    public createButton getQuitBtn() {
        return quitBtn;
    }
}
