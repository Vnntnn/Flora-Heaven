package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.trees.HeartrootPanel;

public class Heartroot extends Tree {
    public Heartroot() {
        super("Heartroot", 100.0, 1, new HeartrootPanel());
        addHintList("บรรเทาความดันโลหิตสูง");
        addHintList("สร้างเสริมความสมดุลหัวใจ");
        addHintList("เพิ่มประสิทธิภาพระบบไหลเวียนโลหิต");
    }
}
