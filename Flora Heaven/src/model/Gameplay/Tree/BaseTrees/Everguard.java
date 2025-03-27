package model.Gameplay.Tree.BaseTrees;

import model.Gameplay.Tree.Tree;
import view.trees.EverguardPanel;

public class Everguard extends Tree {
    public Everguard() {
        super("Everguard", 100.0, 1, new EverguardPanel());
    }
}
