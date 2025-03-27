package model.Tree.BaseTrees;

import model.Tree.Tree;
import view.trees.EverguardPanel;

public class Everguard extends Tree {
    public Everguard() {
        super("Everguard", 100.0, 1, new EverguardPanel());
    }
}
