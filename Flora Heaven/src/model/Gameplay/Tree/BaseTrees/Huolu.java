package model.Gameplay.Tree.BaseTrees;

import model.Gameplay.Tree.Tree;
import view.trees.HuoluPanel;

public class Huolu extends Tree {
    public Huolu() {
        super("Huolu", 100.0, 1, new HuoluPanel());
    }
}
