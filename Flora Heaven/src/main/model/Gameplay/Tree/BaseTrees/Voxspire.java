package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.VoxspirePanel;

public class Voxspire extends Tree {
    public Voxspire() {
        super("Voxspire", 100.0, 1, new VoxspirePanel());
    }
}
