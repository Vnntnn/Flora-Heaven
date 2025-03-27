package model;

import model.Tree.Tree;
import model.Tree.TreesCollections.BaseTreeCollection;

import java.util.ArrayList;
import java.util.List;

public class TreesCollections {
    private final List<Tree> trees;

    public TreesCollections() {
        this(new BaseTreeCollection().getBaseTrees());
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