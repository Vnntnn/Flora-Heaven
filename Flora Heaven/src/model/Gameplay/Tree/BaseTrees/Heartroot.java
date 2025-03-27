package model.Gameplay.Tree.BaseTrees;

import model.Gameplay.Tree.Tree;
import view.trees.HeartrootPanel;

public class Heartroot extends Tree {
    public Heartroot() {
        super("Heartroot", 100.0, 1, new HeartrootPanel());
    }
}
