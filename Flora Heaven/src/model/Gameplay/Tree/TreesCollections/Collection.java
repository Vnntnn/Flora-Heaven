package model.Tree.TreesCollections;

import model.Tree.Tree;

import java.util.ArrayList;
import java.util.List;

public abstract class treeCollection {
    private static int DEFAULT_SIZE;
    private final List<Tree> baseTrees;

    public treeCollection() {
        baseTrees = null;
        DEFAULT_SIZE = 12;
        initializeBaseTrees();
    }

    protected treeCollection(List<Tree> baseTrees, int DEFAULT_SIZE) {
        this.baseTrees = baseTrees;
        treeCollection.DEFAULT_SIZE = DEFAULT_SIZE;
    }

    private void initializeBaseTrees() {
    }

    public List<Tree> getBaseTrees() {
        return new ArrayList<>(baseTrees);
    }
}