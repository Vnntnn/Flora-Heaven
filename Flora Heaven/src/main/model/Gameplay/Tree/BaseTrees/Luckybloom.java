package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.LuckybloomPanel;

public class Luckybloom extends Tree {
    public Luckybloom() {
        super("Luckybloom", 100.0, 1, new LuckybloomPanel());
        addHintList("เพิ่มโชค");
        addHintList("เสริมดวง");
        addHintList("ช่วยให้โชคดี");
    }
}
