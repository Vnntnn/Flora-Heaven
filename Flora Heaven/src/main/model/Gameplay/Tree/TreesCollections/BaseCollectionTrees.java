package main.model.Gameplay.Tree.TreesCollections;

import main.model.Gameplay.Tree.BaseTrees.*;
import main.model.Gameplay.Tree.Tree;

import java.util.*;

public class BaseCollectionTrees extends Collection {
    private final List<Tree> baseTrees;
    private static final List<Tree> DEFAULT_BASE_TREES = List.of(
            new Huolu(),
            new Mindspire(),
            new SilentisShade(),
            new Voxspire(),
            new IllumisSprout(),
            new Heartroot(),
            new Eclipsara(),
            new Lunacrypta(),
            new Luckybloom(),
            new bloodvalorTree(),
            new Everguard(),
            new Chandra()
    );

    public BaseCollectionTrees() {
        baseTrees = new ArrayList<>(DEFAULT_BASE_TREES);
    }

    public List<Tree> getBaseTrees() {
        return new ArrayList<>(baseTrees);
    }
}