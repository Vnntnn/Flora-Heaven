package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.LunacryptaPanel;

public class Lunacrypta extends Tree {
    public Lunacrypta() {
        super("Lunacrypta", 100.0, 1, new LunacryptaPanel());
    }
}
