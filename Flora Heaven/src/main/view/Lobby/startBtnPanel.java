package main.view.Lobby;

/*
  @author tipwareeetaokhotsee
*/

import javax.swing.*;

public class startBtnPanel extends JPanel {
    private createButton startBtn;

    public startBtnPanel() {
        setLayout(null);
        setOpaque(false);
        
        startBtn = new createButton("Start", 113,365);
        add(startBtn);
    }

    public JButton getStartBtn() {
        return startBtn;
    }
}
