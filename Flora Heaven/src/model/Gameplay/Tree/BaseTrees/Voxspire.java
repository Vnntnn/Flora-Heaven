package model.Tree.BaseTrees;

import model.Tree.Tree;
import view.trees.VoxspirePanel;

public class Voxspire extends Tree {
    public Voxspire() {
        super("Voxspire", 100.0, 1, new VoxspirePanel());
    }
}
