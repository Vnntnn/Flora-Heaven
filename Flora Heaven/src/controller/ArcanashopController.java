package controller;

import view.Gamewindow.ArcanashopWindow;
import view.gameplay.Arcanashop.MainQuestPanel;

import java.awt.event.MouseEvent;

public class ArcanashopController {
    private ArcanashopWindow arcanashopWindow;
    private MainQuestPanel mainQuestPanel;

    public ArcanashopController(ArcanashopWindow arcanashopWindow) {
        this.arcanashopWindow = arcanashopWindow;
        this.mainQuestPanel = new MainQuestPanel(this); // ส่ง Controller ไปให้
    }

    public void onMainQuestClicked(MouseEvent e) {
        System.out.println("Main Quest Clicked at (" + e.getX() + ", " + e.getY() + ")");
        // ใส่โค้ดสำหรับเปลี่ยนหน้า หรือแสดง UI อื่นๆ ได้
    }
}
