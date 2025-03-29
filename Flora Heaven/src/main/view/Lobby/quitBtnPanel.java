package main.view.Lobby;

/*
  @author tipwareeetaokhotsee
*/

import javax.swing.*;

public class quitBtnPanel extends JPanel {
    private createButton quitBtn;

    public quitBtnPanel() {
        setLayout(null); 
        setOpaque(false); 
        
        quitBtn = new createButton("Quit", 113,470);
        add(quitBtn);
        
    }

    public JButton getQuitBtn() {
        return quitBtn;
    }
}
