package model.Gameplay.Tree.TreesCollections;

import model.Gameplay.Tree.BaseTrees.*;
import model.Gameplay.Tree.Tree;

import java.util.*;

public class BaseCollectionTrees extends Collection {
    private final List<Tree> baseTrees;
    private static final List<Tree> DEFAULT_BASE_TREES = List.of(
            new Luckybloom(),
            new bloodvalorTree(),
            new Everguard(),
            new Chandra(),
            new Huolu(),
            new Voxspire(),
            new Eclipsara(),
            new Heartroot(),
            new Mindspire(),
            new Lunacrypta(),
            new IllumisSprout(),
            new SilentisShade()
    );

    public BaseCollectionTrees() {
        baseTrees = new ArrayList<>(DEFAULT_BASE_TREES);
    }

    public List<Tree> getBaseTrees() {
        return new ArrayList<>(baseTrees);
    }
}