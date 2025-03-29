package main.model.Gameplay.Tree.TreesCollections;

import main.model.Gameplay.Tree.Tree;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private static int DEFAULT_SIZE;
    private final List<Tree> baseTrees;

    public Collection() {
        baseTrees = null;
        DEFAULT_SIZE = 12;
        initializeBaseTrees();
    }

    protected Collection(List<Tree> baseTrees, int DEFAULT_SIZE) {
        this.baseTrees = baseTrees;
        Collection.DEFAULT_SIZE = DEFAULT_SIZE;
    }

    private void initializeBaseTrees() {
    }

    public List<Tree> getBaseTrees() {
        return new ArrayList<>(baseTrees);
    }
}