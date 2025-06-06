package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.HeartrootPanel;

public class Heartroot extends Tree {
    public Heartroot() {
        super("Heartroot", 480, 1, new HeartrootPanel());
        addHintList("บรรเทาความดันโลหิตสูง");
        addHintList("สร้างเสริมความสมดุลหัวใจ");
        addHintList("เพิ่มประสิทธิภาพระบบไหลเวียนโลหิต");
    }
}
