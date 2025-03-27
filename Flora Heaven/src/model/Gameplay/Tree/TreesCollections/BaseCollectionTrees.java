package model.Gameplay.Tree.TreesCollections;

import model.Gameplay.Tree.BaseTrees.*;
import model.Gameplay.Tree.Tree;

import java.util.*;

public class BaseCollectionTrees extends Collection {
    private final List<Tree> baseTrees;
    private static final List<Tree> DEFAULT_BASE_TREES = List.of(
            new Huolu(),
            new Chandra(),
            new Voxspire(),
            new Eclipsara(),
            new Everguard(),
            new Heartroot(),
            new Mindspire(),
            new Luckybloom(),
            new Lunacrypta(),
            new IllumisSprout(),
            new SilentisShade(),
            new bloodvalorTree()
    );

    public BaseCollectionTrees() {
        baseTrees = new ArrayList<>(DEFAULT_BASE_TREES);
    }

    public List<Tree> getBaseTrees() {
        return new ArrayList<>(baseTrees);
    }
}