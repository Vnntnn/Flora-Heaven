package model.Gameplay.Tree.BaseTrees;

import model.Gameplay.Tree.Tree;
import view.trees.LuckybloomPanel;

public class Luckybloom extends Tree {
    public Luckybloom() {
        super("Luckybloom", 100.0, 1, new LuckybloomPanel());
    }
}
