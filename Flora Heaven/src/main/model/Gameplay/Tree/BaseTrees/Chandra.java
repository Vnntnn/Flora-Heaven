package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.ChandraPanel;

public class Chandra extends Tree {
    public Chandra() {
        super("Chandra", 150.0, 1, new ChandraPanel());
        addHintList("ทำให้ร่ำรวย");
        addHintList("เสริมความมั่งคั่ง");
        addHintList("ทำให้เงินทองไหลมาเทมา");
    }
}
