package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.trees.EverguardPanel;

public class Everguard extends Tree {
    public Everguard() {
        super("Everguard", 100.0, 1, new EverguardPanel());
    }
}
