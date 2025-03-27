package model.Gameplay.Tree.BaseTrees;

import model.Gameplay.Tree.Tree;
import view.trees.MindspirePanel;

public class Mindspire extends Tree {
    public Mindspire() {
        super("Mindspire", 100.0, 1, new MindspirePanel());
    }
}
