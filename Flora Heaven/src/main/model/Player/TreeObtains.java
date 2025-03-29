package main.model.Player;

// ***
// Author: Vnntnn
// ***

import main.model.Gameplay.Tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeObtains {
    private List<Tree> obtainedTree;

    public TreeObtains() {
        this.obtainedTree = new ArrayList<>();
    }

    public TreeObtains(List<Tree> obtainedTree) {
        this.obtainedTree = obtainedTree;
    }

    public void addTree(Tree tree) {
        this.obtainedTree.add(tree);
    }

    public boolean hasTree(Tree tree) {
        return this.obtainedTree.contains(tree);
    }

    public List<Tree> getObtainedTree() {
        return obtainedTree;
    }
}
