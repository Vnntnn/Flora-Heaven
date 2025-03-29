package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.trees.VoxspirePanel;

public class Voxspire extends Tree {
    public Voxspire() {
        super("Voxspire", 850.0, 1, new VoxspirePanel());
    }
}
