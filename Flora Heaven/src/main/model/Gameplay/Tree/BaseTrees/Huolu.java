package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.trees.HuoluPanel;

public class Huolu extends Tree {
    public Huolu() {
        super("Huolu", 100.0, 1, new HuoluPanel());
    }
}
