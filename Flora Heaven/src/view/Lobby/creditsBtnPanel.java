package view.Lobby;

/*
  @author tipwareeetaokhotsee
*/

import javax.swing.*;

public class creditsBtnPanel extends JPanel {
    private createButton creditseButton;

    public creditsBtnPanel() {
        setLayout(null); 
        setOpaque(false); 
        
        creditseButton = new createButton("Credits", 113,418);
        add(creditseButton);
    }

    public JButton getCreditseButton() {
        return creditseButton;
    }
}