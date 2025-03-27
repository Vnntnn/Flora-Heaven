package model.Gameplay.Tree.TreesCollections;

import model.Gameplay.Tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreesCollections {
    private final List<Tree> trees;

    public TreesCollections() {
        this(new BaseCollectionTrees().getBaseTrees());
    }

    public TreesCollections(List<Tree> listTrees) {
        trees = new ArrayList<>(listTrees);
    }

    public List<Tree> getTrees() {
        return new ArrayList<>(trees);
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }
}