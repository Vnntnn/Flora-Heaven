package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.trees.HeartrootPanel;

public class Heartroot extends Tree {
    public Heartroot() {
        super("Heartroot", 480.0, 1, new HeartrootPanel());
    }
}
