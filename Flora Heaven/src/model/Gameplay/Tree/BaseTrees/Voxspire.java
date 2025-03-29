package model.Gameplay.Tree.BaseTrees;

import model.Gameplay.Tree.Tree;
import view.trees.VoxspirePanel;

public class Voxspire extends Tree {
    public Voxspire() {
        super("Voxspire", 850.0, 1, new VoxspirePanel());
    }
}
