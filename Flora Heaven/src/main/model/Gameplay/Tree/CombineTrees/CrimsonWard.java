package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.VoxspirePanel;
import main.view.AssetsLoader.trees.treescombine.CrimsonWardPanel;

public class CrimsonWard extends Tree{
    public CrimsonWard(){
        super("Crimson Ward",40,2,new CrimsonWardPanel());
    }
}
