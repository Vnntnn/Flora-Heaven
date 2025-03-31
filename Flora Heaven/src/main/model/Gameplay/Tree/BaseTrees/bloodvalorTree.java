package main.model.Gameplay.Tree.BaseTrees;

import java.util.ArrayList;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.Bloodvalor_blossomPanel;

public class bloodvalorTree extends Tree {
    public bloodvalorTree() {
        super("BloodValor Blossom", 150.0, 1, new Bloodvalor_blossomPanel());
        addHintList("เสริมพละกำลัง");
        addHintList("เพิ่มกำลังกาย");
        addHintList("ทำให้ถึกทน");
    }
}
