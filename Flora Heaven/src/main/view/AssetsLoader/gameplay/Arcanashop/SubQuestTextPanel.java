package main.view.gameplay.Arcanashop;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubQuestTextPanel extends JPanel{
    private JLabel hintJLabel1,hintJLabel2,hintJLabel3;
    public SubQuestTextPanel(){
        hintJLabel1 = new JLabel("ข้าต้องการต้นไม้ที่");
        hintJLabel2 = new JLabel("LuckBloom");
        hintJLabel3 = new JLabel("Bloodvalor");
        hintJLabel1.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
        hintJLabel2.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
        hintJLabel3.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
        add(hintJLabel1);
        add(hintJLabel2);
        add(hintJLabel3);
    }
    public JLabel getHintJLabel3() {
        return hintJLabel3;
    }
    public JLabel getHintJLabel2() {
        return hintJLabel2;
    }
    public JLabel getHintJLabel1() {
        return hintJLabel1;
    }
    

    
}
