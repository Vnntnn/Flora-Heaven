package model.Tree.BaseTrees;

import model.Tree.Tree;
import view.trees.LuckybloomPanel;

public class Luckybloom extends Tree {
    public Luckybloom() {
        super("Luckybloom", 100.0, 1, new LuckybloomPanel());
    }
}
